package com.example.registrationform;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class Second_activity extends AppCompatActivity
{
    TextView detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        String textviewa= getIntent().getStringExtra("my data");


        detail=findViewById(R.id.textview3);
        detail.setText(textviewa);

    }

}
