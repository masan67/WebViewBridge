package com.marioapps.webviewbridge;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data;
    String dataParsed = "";
    String singleParsed = "";
    String[] arrayStrings;

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://api.myjson.com/bins/qwpvj");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            arrayStrings = data.split("null");

            JSONArray ja = new JSONArray(arrayStrings[1]);
            for(int i=0;i<ja.length();i++){
                JSONObject jo = (JSONObject) ja.get(i);
                singleParsed = "Name:"+jo.get("name")+"\n"+
                        "Password:"+jo.get("password")+"\n"+
                        "Contact:"+jo.get("contact")+"\n"+
                        "Country:"+jo.get("country")+"\n";
                
                dataParsed = dataParsed + singleParsed +"\n";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.textView.setText(dataParsed);
    }

}

