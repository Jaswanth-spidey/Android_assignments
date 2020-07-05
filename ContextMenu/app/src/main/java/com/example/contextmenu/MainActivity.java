package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button contextmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contextmenu = findViewById(R.id.contextmenu);
        registerForContextMenu(contextmenu);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.example_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.notifications:
                Toast.makeText(this,"Notifications selected", Toast.LENGTH_SHORT).show();
            case R.id.help:
                Toast.makeText(this,"Help selected", Toast.LENGTH_SHORT).show();
            case R.id.settings:
                Toast.makeText(this,"Settings selected", Toast.LENGTH_SHORT).show();
            case R.id.logout:
                Toast.makeText(this,"Logout selected", Toast.LENGTH_SHORT).show();
            default:
                return super.onContextItemSelected(item);

        }



    }
}