package com.example.covid_19api;

//Asynctask application of covid-19 app.

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);
    }

    Covid_task taskq = new Covid_task(MainActivity.this, recyclerView);

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Nullable
    @Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        callback= (ActionMode.Callback) taskq.execute();
        return super.startActionMode(callback);
    }

}