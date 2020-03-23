package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calcuation extends AppCompatActivity {
    EditText txtInput1,txtInput2,txtInput3;
    TextView txtResult;
    Button btnCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcuation);
        mapUItoProperties();
        btnCalculate.setOnClickListener((View v) -> {
            int A=Integer.parseInt(txtInput1.getText().toString());
            int B=Integer.parseInt(txtInput2.getText().toString());
            int C=Integer.parseInt(txtInput3.getText().toString());
            int result=A+B+C;
            txtResult.setText(String.valueOf(result));
        });

    }

        public void mapUItoProperties(){
            txtInput1=findViewById(R.id.txtInput1);
            txtInput2=findViewById(R.id.txtInput2);
            txtInput3=findViewById(R.id.txtInput3);
            btnCalculate=findViewById(R.id.btnCalculate);
            txtResult=findViewById(R.id.txtResult);
        }

    }


