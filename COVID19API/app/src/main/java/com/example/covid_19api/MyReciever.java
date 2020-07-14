package com.example.covid_19api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String status = NetworkUtil.getConnectivityStatusString(context);
        if (status.isEmpty()){
            status= "Net on chey";
        }
        Toast.makeText(context, ""+status, Toast.LENGTH_SHORT).show();
    }
}
