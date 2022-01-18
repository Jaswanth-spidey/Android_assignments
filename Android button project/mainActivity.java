package com.example.countapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{
    TextView tv;
    int a=0;
    int temp=a;
    Button b11;
    Button b22;
    Button b33;
    Button b44;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textview);
        b11=findViewById(R.id.b1);
        b22=findViewById(R.id.b2);
        b33=findViewById(R.id.b3);
        b44=findViewById(R.id.b4);

        b11.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                //Action
                a++;
                tv.setText("" + a);


            }
        });

        b22.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                //Action
                a--;
                tv.setText("" + a);


            }
        });

        b33.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                //Action
                a=temp;
                temp=a;
                tv.setText("" + a);


            }
        });
        if (savedInstanceState!=null){
            String s=savedInstanceState.getString("Jass");
            a= Integer.parseInt(s);
            tv.setText(""+a);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Jass",tv.getText().toString());
    }

    public void display(View view){
        //Action
        Toast.makeText(this,"Your count is: "+a,Toast.LENGTH_SHORT).show();

    }
}
