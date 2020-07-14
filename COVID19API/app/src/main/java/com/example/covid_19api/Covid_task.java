package com.example.covid_19api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

public class Covid_task extends AsyncTask<Void, Void, String>
{
    String url = "https://api.covid19api.com/dayone/country/IN";
    Context ct;
    ProgressDialog pd;
    RecyclerView rv;

    public Covid_task(MainActivity mainActivity,RecyclerView recyclerView) {
        ct= mainActivity;
        rv = recyclerView;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(ct);
        pd.setMessage("Jaruguthundi wait chey...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL u = new URL(url);
            final HttpsURLConnection connection= (HttpsURLConnection)u.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuilder builder = new StringBuilder();
            while ((line=bufferedReader.readLine()) !=null){
                builder.append(line);
            }
            return builder.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        int i;
        List<Covid_assign> bookList= new ArrayList<>();
        try{

            //Its Jaswanth's code
            JSONArray jsonArray = new JSONArray(s);
            for (i=(jsonArray.length()-1);i>=0;i--){
                JSONObject obj = jsonArray.getJSONObject(i);
                String confirmed = obj.getString("Confirmed");
                String active = obj.getString("Active");
                String deaths = obj.optString("Deaths");
                String date = obj.optString("Date");
                String date1= date.substring(8,10);
                String date2=date.substring(5,7);
                String date3=date.substring(0,4);
                date = date1+"-"+date2+"-"+date3;

                Covid_assign assign= new Covid_assign(confirmed, active,deaths,date);
                bookList.add(assign);
                Log.i("Confirmed",""+confirmed);
                Log.i("Active",""+active);
                Log.i("Deaths",""+deaths);
                Log.i("Date",""+date);
            }
            rv.setLayoutManager(new LinearLayoutManager(ct));
            rv.setAdapter(new Recycler_view(ct,bookList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
