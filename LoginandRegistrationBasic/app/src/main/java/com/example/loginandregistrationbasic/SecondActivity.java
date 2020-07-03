package com.example.loginandregistrationbasic;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String s11=getIntent().getStringExtra("mydata");

        TextView tv=findViewById(R.id.secondtext);
        tv.setText("Welcome: "+s11);
    }


}

