package com.aayush.aayush.sampleapplication;


import android.app.VoiceInteractor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class Fragment_GET extends Fragment {

    private String ip_addr; //must include the port number
    private View root_view;
    public String GET_URL= null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_get, container, false);
        this.root_view = view;
        final EditText edt_txt_id = (EditText)(view.findViewById(R.id.edt_txt_id));
        final TextView txt_vw_name = (TextView)(view.findViewById(R.id.txt_vw_name));
        final TextView txt_vw_address = (TextView)(view.findViewById(R.id.txt_vw_address));


        edt_txt_id.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View vw) {

                if(edt_txt_id.getText().toString().equals("Enter ID")) {
                    edt_txt_id.setText("");
                }
            }

        });

        final Fragment_GET frg = this;
        Button btn_get_record = (Button)view.findViewById(R.id.btn_get_record);
        btn_get_record.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View vw) {

                String str_id = edt_txt_id.getText().toString();
                ip_addr = Fragment_IP.getIp();
                GET_URL = "http://" + ip_addr + "/get.php?id=" + str_id;
                new GETAsynTask().execute(frg);


            }

        });
        return view;
    }

    public void setResponse(String response) {


        final TextView txt_vw_name = (TextView)(root_view.findViewById(R.id.txt_vw_name));
        txt_vw_name.setText(response);
        final TextView txt_vw_address = (TextView)(root_view.findViewById(R.id.txt_vw_address));
        final TextView txt_vw_phn = (TextView)(root_view.findViewById(R.id.txt_vw_phn));
        try {

            JSONObject json = new JSONObject(response);
            String str_name = json.getString("NAME");
            String str_addr = json.getString("ADDRESS");
            String str_phn = json.getString("PHN");

            txt_vw_name.setText(str_name);
            txt_vw_address.setText(str_addr);
            txt_vw_phn.setText(str_phn);

        } catch (JSONException e) {
            //reaches here when not a json object
            txt_vw_name.setText(response);
            txt_vw_address.setText("");
            txt_vw_phn.setText("");
            e.printStackTrace();
        }

    }

}
