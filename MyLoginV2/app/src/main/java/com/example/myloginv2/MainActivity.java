package com.example.myloginv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void clickBtnLogin(View view) {
        Toast.makeText(this,"Login is working",Toast.LENGTH_SHORT).show();
    }

    public void clickGoogle(View view) {
        Toast.makeText(this,"Google is working",Toast.LENGTH_SHORT).show();
    }

    public void clickFacebook(View view) {
        Toast.makeText(this,"Facebook is working",Toast.LENGTH_SHORT).show();
    }

    public void clickSignup(View view) {
        Toast.makeText(this,"Signup is working",Toast.LENGTH_SHORT).show();
    }
}
