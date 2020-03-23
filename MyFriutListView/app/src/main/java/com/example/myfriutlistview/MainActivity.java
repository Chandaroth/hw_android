package com.example.myfriutlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mFruits[]={"Apple","Banana","Kiwi","Mango","Grape","Coconut","Orange","Watermelon"};
    int image[]={R.drawable.apple,R.drawable.banana,R.drawable.kiwi,R.drawable.mango,R.drawable.grape,
    R.drawable.coconut,R.drawable.oranges,R.drawable.watermelon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);


        //now create a  adapter class
        MyAdapter adapter=new MyAdapter(this,mFruits,image);
        listView.setAdapter(adapter);

        //now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(MainActivity.this,"Apple",Toast.LENGTH_SHORT).show();
                }
                if(position==1){
                    Toast.makeText(MainActivity.this,"Banana",Toast.LENGTH_SHORT).show();
                }
                if(position==2){
                    Toast.makeText(MainActivity.this,"Kiwi",Toast.LENGTH_SHORT).show();
                }
                if(position==3){
                    Toast.makeText(MainActivity.this,"Mango",Toast.LENGTH_SHORT).show();
                }
                if(position==4){
                    Toast.makeText(MainActivity.this,"Grape",Toast.LENGTH_SHORT).show();
                }
                if(position==5){
                    Toast.makeText(MainActivity.this,"Coconut",Toast.LENGTH_SHORT).show();
                }
                if(position==6){
                    Toast.makeText(MainActivity.this,"Orange",Toast.LENGTH_SHORT).show();
                }
                if(position==7){
                    Toast.makeText(MainActivity.this,"Watermelon",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        int rImgs[];
        MyAdapter(Context c,String title[],int imgs[]){
            super(c,R.layout.row,R.id.textView,title);
            this.rTitle=title;
            this.rImgs=imgs;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images=row.findViewById(R.id.image);
            TextView myTitle=row.findViewById(R.id.textView);

            //now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);

            return row;
        }
    }
}
