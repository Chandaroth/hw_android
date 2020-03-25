package com.example.myapp;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Server {

    public Server() {

    }

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    public void sendGETRequest(final IMyActivity activity) {
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/users")
                .build();
        Call call = client.newCall(request);
        final ArrayList<User> users = new ArrayList<>();
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response) {
                //success
                System.out.println("success");//success, but I want to get a list of Photo's object ?
                try {
                    String jsonString = response.body().string();
                    JSONArray responseArray = new JSONArray(jsonString);
                    for (int i = 0; i < responseArray.length(); i++) {
                        User user = User.createFromJSONObject(responseArray.getJSONObject(i));
                        users.add(user);


                        //int id=user.getId("id");
                    }
                    ((Activity)activity).runOnUiThread(new Runnable() {
                        public void run() {
                            activity.getResponse(users, null);
                        }
                    });
                } catch (Exception e){
                    System.out.println("failed sending request"+e.toString());
                }

            }

            public void onFailure(Call call, IOException e) {
                System.out.println("failed");
            }
        });
    }
}
