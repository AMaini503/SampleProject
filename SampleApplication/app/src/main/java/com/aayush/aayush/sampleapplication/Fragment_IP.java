package com.aayush.aayush.sampleapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment_IP extends Fragment {

    private static String ip_addr = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ip, container, false);
        Button btn_use_ip =  (Button) (view.findViewById(R.id.btn_use_ip));
        btn_use_ip.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                EditText edt_txt_ip = (EditText)getView().findViewById(R.id.edt_txt_ip);
                ip_addr = edt_txt_ip.getText().toString();
            }

        });
        return view;
    }

    public static String getIp() {
        return ip_addr;
    }

}
