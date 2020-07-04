package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText rollno1,name1,phone1,emailid1,password1;
    Button submit1;
    Spinner department1;
    RadioButton male1,female1;
    String last;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollno1=findViewById(R.id.rollno);
        name1=findViewById(R.id.name);
        phone1=findViewById(R.id.phoneno);
        emailid1=findViewById(R.id.emailid);
        password1=findViewById(R.id.password);

        submit1=findViewById(R.id.submit);

        department1=findViewById(R.id.department);
        male1=findViewById(R.id.male);
        female1=findViewById(R.id.female);

        ArrayAdapter<CharSequence> department_adapter = ArrayAdapter.createFromResource(this,
                R.array.Department, android.R.layout.simple_spinner_item);
        department1.setAdapter(department_adapter);

        department1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i==-1 | i==0 )
                {
                    Toast.makeText(MainActivity.this, "Please select the department", Toast.LENGTH_SHORT).show();

                }

                if(i==1)
                {
                    ArrayAdapter<CharSequence> atp_department= ArrayAdapter.createFromResource(MainActivity.this,R.array.Department,
                            android.R.layout.simple_spinner_item);
                    department1.setAdapter(atp_department);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rollno= rollno1.getText().toString();
                String name=name1.getText().toString();
                String phone= phone1.getText().toString();
                String emailid= emailid1.getText().toString();
                String password= password1.getText().toString();
                if (male1.isChecked())
                {
                    gender = male1.getText().toString();
                }
                if (female1.isChecked())
                {
                    gender = female1.getText().toString();
                }


                String department= department1.getSelectedItem().toString();
                if (rollno.isEmpty() | name.isEmpty() | emailid.isEmpty() | phone.isEmpty() | password.isEmpty() | department.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter all the details...",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(MainActivity.this, Second_activity.class);
                    i.putExtra("my data",rollno+"\n"+name+"\n"+phone+"\n"+emailid+"\n"+password+"\n"+gender+"\n"+department);
                    startActivity(i);
                }
            }

        });

    }
}