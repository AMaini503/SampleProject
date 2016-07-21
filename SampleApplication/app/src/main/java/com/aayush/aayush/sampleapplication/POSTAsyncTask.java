package com.aayush.aayush.sampleapplication;


import android.os.AsyncTask;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class POSTAsyncTask extends AsyncTask<Fragment_POST, Void, Void> {

    private Fragment_POST frg_post = null;
    private String response = null;
    private URL url = null;
    @Override
    protected Void doInBackground(Fragment_POST... params) {

        String ip_addr = Fragment_IP.getIp();
        frg_post = params[0];

        HttpURLConnection connection = null;
        try {
            url = new URL("http://" + ip_addr + "/post.php");
            connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");

            String urlparams = "json_string=";

            String str_name = frg_post.getTxt_name();
            String str_addr = frg_post.getTxt_addr();
            String str_phn = frg_post.getTxt_phn();

            JSONObject json_obj = new JSONObject();
            try {
                json_obj.put("NAME", str_name);
                json_obj.put("ADDRESS", str_addr);
                json_obj.put("PHN", str_phn);
                urlparams += json_obj.toString();

            } catch (JSONException e) {
                e.printStackTrace();
            }

            DataOutputStream dStream = new DataOutputStream(connection.getOutputStream());
            dStream.writeBytes(urlparams);
            dStream.flush();
            dStream.close();


            //reading the response
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            StringBuffer responseOutput = new StringBuffer();;
            while((line = br.readLine()) != null ) {
                responseOutput.append(line);
            }
            br.close();
            response = responseOutput.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void vd) {
        frg_post.setResponse(response);
    }
}
