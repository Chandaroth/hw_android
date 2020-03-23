package com.example.mygridviewbutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    GridView gridView;
    Button btnAdd;

    int[]gridViewImage={
            R.drawable.badoo,
            R.drawable.behance,
            R.drawable.deviantart,
            R.drawable.dribbble,
            R.drawable.facebook,
            R.drawable.flickr,
            R.drawable.googleplus,
            R.drawable.instagram,
            R.drawable.lastfm,
            R.drawable.linkedin,
            R.drawable.pinterest,
            R.drawable.soundcloud,
            R.drawable.swarm,
            R.drawable.tumblr,
            R.drawable.twitter,
            R.drawable.vk,
            R.drawable.telegram,
            R.drawable.vimeo,

    };
    String[]gridViewText={
            "Badoo","Behance","Deviantart","Dribbble",
            "Facebook","Flickr","Googleplus","Instagram",
            "Lastfm","Linkedin","Pinterest",
            "Soundcloud","Swarm","Tumblr","Twitter","VK","Telegram"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomGridView customGridView=new CustomGridView(MainActivity.this, gridViewImage,gridViewText );
        gridView=findViewById(R.id.gridViewImageText);
        gridView.setAdapter(customGridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,gridViewText[+position],Toast.LENGTH_SHORT).show();;
            }
        });
        btnAdd=findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


}

