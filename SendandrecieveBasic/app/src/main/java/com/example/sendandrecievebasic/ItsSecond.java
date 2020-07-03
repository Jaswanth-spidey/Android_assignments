package com.example.sendandrecievebasic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ItsSecond extends AppCompatActivity
{
    TextView replymessagestatus;
    TextView messagessent;
    EditText replymess;
    Button reply1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        replymessagestatus=findViewById(R.id.sendmessagestatus);
        messagessent=findViewById(R.id.sendmessages);
        replymess=findViewById(R.id.replytext);
        reply1=findViewById(R.id.reply);
        String ss= getIntent().getStringExtra("mydata");
        messagessent.setText(ss);


        reply1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });
    }
    public void openActivity1()
    {
        String data1 = replymess.getText().toString();

        if(data1.isEmpty())
        {
            Toast.makeText(this, "Please enter any text to send", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Intent i1=new Intent(ItsSecond.this, MainActivity.class);
            i1.putExtra("seconddata", data1);
            i1.putExtra("welcome", "Message Recieved");
            startActivity(i1);
        }
    }

}
