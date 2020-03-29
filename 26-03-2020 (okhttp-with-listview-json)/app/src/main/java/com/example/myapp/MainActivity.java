package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
Example code of sending request to Server/Backend
FROM Mobile app
EXample of api:
GET request
https://jsonplaceholder.typicode.com/photos
For testing request, let's use Postman(from Google)
How to send request from Android ? Many libraries, for example: okhttp
Now install and use it !
* */
public class MainActivity extends AppCompatActivity implements IMyActivity{
    private TextView textView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView = findViewById(R.id.textView);
        //call for testing
        Server server = new Server();

        server.sendGETRequest(this);

    }

    @Override
    public void getResponse(Object result, String error) {
        /*User user=new User();
        String text[] = {String.valueOf("ID: "+user.getId()+"" +
                "   Name: "+user.getName())};
        listView=findViewById(R.id.listViewMain);


        //now create a  adapter class
        MyAdapter adapter=new MyAdapter(this,text);
        listView.setAdapter(adapter);*/

    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String text[];
        MyAdapter(Context c,String name[]){
            super(c,R.layout.item,R.id.listViewMain,name);

            this.text=name;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.item,parent,false);
            TextView myTitle=row.findViewById(R.id.name_item);
            //now set our resources on views
            myTitle.setText(text[position]);

            return row;
        }
    }
}
