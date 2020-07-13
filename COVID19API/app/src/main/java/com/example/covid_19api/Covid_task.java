package com.example.covid_19api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class Covid_task<Book> extends AsyncTask<Void,Void,String>
{
    String url = "https://api.covid19api.com/dayone/country/IN";
    String myurl=url;
    Context ct;
    ProgressDialog pd;
    RecyclerView rv;

    public Covid_task(MainActivity mainActivity, RecyclerView recyclerView) {
        ct= mainActivity;
        rv = recyclerView;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(ct);
        pd.setMessage("Jaruguthundi wait chey...");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL u = new URL(myurl);
            HttpsURLConnection connection= (HttpsURLConnection)u.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            reader.read(CharBuffer.wrap(myurl));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        List<Covid_assign> bookList= new ArrayList<>();
        int i;
        try{
            JSONArray jsonArray = new JSONArray().getJSONArray(Integer.parseInt(myurl));
            JSONObject rootJSONobject = new JSONObject().getJSONObject(String.valueOf(jsonArray));

            for (i=jsonArray.length();i>0;i--){
                JSONObject confirmedjsonobject = rootJSONobject.getJSONObject("Confirmed");
                String confirmed = confirmedjsonobject.optString("confirmed");
                JSONObject activejsonobject = rootJSONobject.getJSONObject("Active");
                String active = activejsonobject.optString("active");
                JSONObject deathsjsonobject = rootJSONobject.getJSONObject("Deaths");
                String deaths = deathsjsonobject.optString("deaths");
                JSONObject datejsonobject = rootJSONobject.getJSONObject("Date");
                String date = datejsonobject.optString("date");

                Covid_assign assign= new Covid_assign(confirmed, active,deaths,date);
                bookList.add(assign);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
