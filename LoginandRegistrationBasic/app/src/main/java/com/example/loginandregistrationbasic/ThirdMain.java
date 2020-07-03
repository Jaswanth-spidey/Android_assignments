package com.example.loginandregistrationbasic;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ThirdMain extends AppCompatActivity {
    EditText et11;
    EditText e22;
    EditText e33;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        et11=findViewById(R.id.newuser);
        e22=findViewById(R.id.newpass);
        e33=findViewById(R.id.confirmpass);

    }



}
