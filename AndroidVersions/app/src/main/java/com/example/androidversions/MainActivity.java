package com.example.androidversions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recycler);

        int images[] = {R.drawable.alpha,R.drawable.beta,R.drawable.cupcake,R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb,R.drawable.icecreamsandwich,R.drawable.jellybean,R.drawable.kitkat,R.drawable.lollipop,R.drawable.marshmallow,R.drawable.nougat,R.drawable.oreo,R.drawable.pie,R.drawable.q,R.drawable.r};
        String codenumber[] = {"1.1","1.2","1.5","1.6","2.0 - 2.1", "2.2", "2.3", "3.0 - 3.2", "4.0", "4.1 - 4.3", "4.4", "5 - 5.1", "6", "7 - 7.1", "8 - 8.1", "9", "10","11"};
        String versionn[] = {"Alpha", "Beta", "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Icecreamsandwich", "Jellybean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo", "Pie", "Q","R"};
        String apilevell[]= {"API Level 1", "API Level 2", "API Level 3", "API Level 4", "API Level 5 -7", "API Level 8", "API Level 9 - 10", "API Level 11 - 13", "API Level 14 - 15", "API Level 16 - 18", "API Level 19", "API Level 21 - 22", "API Level 23", "API Level 24 - 25","API Level 26 - 27", "API Level 28", "API Level 29" ,"API Level 30"};
        String relesedate[]= {"September 23, 2008", "February 9, 2009", "April 27, 2009", "September 15, 2009", "October 26, 2009", "May 20, 2010", "December 6, 2010", "February 9, 2011", "February 22, 2011", "October 18, 2011", "July 9, 2012","October 31, 2013", "November 12, 2014", "October 5, 2015", "August 22, 2016", "August 21, 2017", "August 6, 2018", "September 3, 2019", "February 19, 2020"};
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycler_android adapter = new recycler_android(this,images,codenumber,versionn, apilevell, relesedate);
        recyclerView.setAdapter(adapter);

    }
}