package com.hean.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.hean.sqlitecrud.database.DBHandler;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    ListView listView;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listView=findViewById(R.id.listViewShow);
        dbHandler=new DBHandler(this);

       /* ArrayList<String>list =dbHandler.getUsers();

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.listdata,list);
        listView.setAdapter(adapter);*/

       ArrayList<String> theList=new ArrayList<>();
       Cursor data= dbHandler.getListContents();

       if(data.getCount()==0){
           Toast.makeText(ViewActivity.this,"The Database is Empty", android.widget.Toast.LENGTH_SHORT).show();
       }else{
           while (data.moveToNext()){
               theList.add(data.getString(1));
               ListAdapter listAdapter=new ArrayAdapter<>(this,R.layout.listdata,theList);
               listView.setAdapter(listAdapter);
           }
       }


    }
}
