package com.georgy.newapp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

class GetFromURL extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... voids) {
        String url = "http://www.mocky.io/v2/56fa31e0110000f920a72134";
        String jsonString = null;
        try {
            InputStream is = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder builder = new StringBuilder();
            int cp;
            while ((cp = reader.read()) != -1) {
                builder.append((char) cp);
            }
            jsonString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

    }

    public static HST getCompany() {
        String line = null;
        try {
            GetFromURL getFromURL = new GetFromURL();
            getFromURL.execute();
            line = getFromURL.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        TransformFromJson transformFromJson = new TransformFromJson(line);
        HST companyOne = transformFromJson.returnCompany();
        Collections.sort(companyOne.company.employees);
        return companyOne;
    }
}
