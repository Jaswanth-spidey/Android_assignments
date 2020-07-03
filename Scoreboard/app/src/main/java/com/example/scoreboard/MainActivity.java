package com.example.scoreboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    int a=0;
    int b=0;
    TextView tv12;
    TextView tv22;
    Button b111;
    Button b112;
    Button b113;
    Button b121;
    Button b122;
    Button b123;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b111=findViewById(R.id.b11);
        b112=findViewById(R.id.b12);
        b113=findViewById(R.id.b13);
        b121=findViewById(R.id.b21);
        b122=findViewById(R.id.b22);
        b123=findViewById(R.id.b23);
        tv12=findViewById(R.id.textv12);
        tv22=findViewById(R.id.textv22);
        b111.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //Action
                                        a+=3;
                                        tv12.setText(""+a);
                                    }
                                }
        );
        b112.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //Action
                                        a+=2;
                                        tv12.setText(""+a);
                                    }
                                }
        );
        b113.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //Action
                                        a++;
                                        tv12.setText(""+a);
                                    }
                                }
        );
        b121.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //Action
                                        b+=3;
                                        tv22.setText(""+b);
                                    }
                                }
        );
        b122.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //Action
                                        b+=2;
                                        tv22.setText(""+b);
                                    }
                                }
        );
        b123.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        //Action
                                        b++;
                                        tv22.setText(""+b);
                                    }
                                }
        );

        if(savedInstanceState!=null)
        {
            String s1=savedInstanceState.getString("Jass1");
            a= Integer.parseInt(s1);
            tv12.setText(""+a);
        }
        if(savedInstanceState!=null)
        {
            String s2=savedInstanceState.getString("Jass2");
            a= Integer.parseInt(s2);
            tv22.setText(""+b);
        }
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Jass1",tv12.getText().toString());
        outState.putString("Jass2",tv22.getText().toString());
    }
}


