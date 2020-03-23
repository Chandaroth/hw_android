package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtName,txtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapUIToProperties();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUsernameAndPassword(txtName.getText().toString()
                        ,txtPassword.getText().toString());
            }
        });

    }

    public void validateUsernameAndPassword(String username,String password){
        if(username.length()<2 || password.length() < 2) {
            Toast.makeText(this,"Username and Password must at least 2 characters"
                    ,Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Username is "+txtName.getText().toString()
                    +"\nPassword is "+txtPassword.getText().toString(),Toast.LENGTH_SHORT).show();
        }
    }

    public void mapUIToProperties(){
        txtName=findViewById(R.id.txtName);
        txtPassword=findViewById(R.id.txtPassword);
        btnLogin=findViewById(R.id.btnLogin);
    }

}
