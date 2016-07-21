package com.aayush.aayush.sampleapplication;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GETAsynTask extends AsyncTask<Fragment_GET, Void, Void> {

    private String str_response = null;
    private Fragment_GET frag_get = null;
    @Override
    protected Void doInBackground(Fragment_GET... params) {

        frag_get = params[0];
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(params[0].GET_URL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");

//            Getting the response back
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuffer response = new StringBuffer();
            String line = null;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            str_response = response.toString();
            rd.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
         finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    @Override
    public void onPostExecute(Void vd) {
        frag_get.setResponse(str_response);
    }
}
