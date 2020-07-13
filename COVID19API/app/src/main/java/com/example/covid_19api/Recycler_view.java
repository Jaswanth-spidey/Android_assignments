package com.example.covid_19api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recycler_view extends RecyclerView.Adapter<Recycler_view.myViewHolder>
{
    Context ct;
    List<Covid_assign> myList;

    public Recycler_view(Context ct1,List<Covid_assign> caseslist ){
        ct=ct1;
        myList = caseslist;
    }

    @NonNull
    @Override
    public Recycler_view.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.recycler_view, parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_view.myViewHolder holder, int position) {
        Covid_assign list = myList.get(position);
        holder.tv_confirmed.setText(list.getConfirmed());
        holder.tv_date.setText(list.getDate());
        holder.tv_active.setText(list.getActive());
        holder.tv_deaths.setText(list.getDeaths());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView tv_confirmed, tv_active, tv_date, tv_deaths;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_confirmed= itemView.findViewById(R.id.confirmed1);
            tv_active= itemView.findViewById(R.id.active1);
            tv_date=itemView.findViewById(R.id.date1);
            tv_deaths= itemView.findViewById(R.id.deaths1);
        }
    }
}
