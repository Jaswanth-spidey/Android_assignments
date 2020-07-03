package com.example.sendandrecievebasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    TextView message_status;
    TextView message;
    EditText sentmaessages;
    Button send1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message_status=findViewById(R.id.firstttext);
        message=findViewById(R.id.displaymessage);
        sentmaessages=findViewById(R.id.sendtext);
        send1=findViewById(R.id.send);

        String ss= getIntent().getStringExtra("seconddata");
        message.setText(ss);

        String s11= getIntent().getStringExtra("welcome");
        message_status.setText(s11);


        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondActivity();
            }
        });
    }

    public void openSecondActivity()
    {
        String data = sentmaessages.getText().toString();

        if(data.isEmpty())
        {
            Toast.makeText(this, "Please enter any text to send", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Intent i1=new Intent(MainActivity.this, ItsSecond.class);
            i1.putExtra("mydata", data);
            startActivity(i1);
        }

    }
}