package com.example.androidversions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class recycler_android extends RecyclerView.Adapter<recycler_android.recycle_details>
{
    int myImages[];
    String mycodename[],myapilevel[],myversionnumber[],myreleasedate[];
    Context ct;

    public recycler_android(MainActivity mainActivity, int images1[], String codename[], String version[], String apilevel[],String releasedate[]) {
        myImages = images1;
        mycodename = codename;
        myversionnumber = version;
        myapilevel = apilevel;
        myreleasedate = releasedate;
        ct=mainActivity;
    }
    public class recycle_details extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView codename1,versionname1,apilevel1,releasedate1;

        public recycle_details(@NonNull View itemView)
        {
            super(itemView);
            iv = itemView.findViewById(R.id.images);
            codename1= itemView.findViewById(R.id.codename);
            versionname1 = itemView.findViewById(R.id.version);
            releasedate1 = itemView.findViewById(R.id.releasedate);
            apilevel1 = itemView.findViewById(R.id.apilevel);
        }
    }


    @NonNull
    @Override
    public recycler_android.recycle_details onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.recyclerview, parent, false);
        recycle_details recycledetails = new recycle_details(v);
        return recycledetails;
    }

    @Override
    public void onBindViewHolder(@NonNull recycler_android.recycle_details holder, int position) {
        holder.iv.setImageResource(myImages[position]);
        holder.codename1.setText(mycodename[position]);
        holder.versionname1.setText(myversionnumber[position]);
        holder.apilevel1.setText(myapilevel[position]);
        holder.releasedate1.setText(myreleasedate[position]);
    }

    @Override
    public int getItemCount() {
        return myImages.length;
    }


}
