package com.aayush.aayush.sampleapplication;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Fragment_POST extends Fragment {

    public View root_view = null;
    public String txt_name = null;
    public String txt_addr = null;
    public String txt_phn = null;

    public EditText edt_txt_name = null;
    public EditText edt_txt_addr = null;
    public EditText edt_txt_phn = null;
    public TextView txt_vw_response = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root_view =  inflater.inflate(R.layout.fragment_post, container, false);
        edt_txt_name = (EditText)root_view.findViewById(R.id.edt_txt_name);
        edt_txt_addr = (EditText)root_view.findViewById(R.id.edt_txt_addr);
        edt_txt_phn = (EditText)root_view.findViewById(R.id.edt_txt_phn);

        edt_txt_name.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View vw) {

                if(edt_txt_name.getText().toString().equals("Enter Name")) {
                    edt_txt_name.setText("");
                }
            }

        });

        edt_txt_addr.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View vw) {

                if(edt_txt_addr.getText().toString().equals("Enter Address")) {
                    edt_txt_addr.setText("");
                }
            }

        });

        edt_txt_phn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View vw) {

                if(edt_txt_phn.getText().toString().equals("Enter Phone Number")) {
                    edt_txt_phn.setText("");
                }
            }

        });

        txt_vw_response = (TextView)root_view.findViewById(R.id.txt_vw_response);

        Button btn_post_record = (Button)(root_view.findViewById(R.id.btn_post_record));
        final Fragment_POST frg_post =  this;
        btn_post_record.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                new POSTAsyncTask().execute(frg_post);


            }
        });
        return root_view;
    }

    public String getTxt_name()
    {
        return edt_txt_name.getText().toString();
    }
    public String getTxt_addr() {
        return edt_txt_addr.getText().toString();
    }
    public String getTxt_phn() {
        return edt_txt_phn.getText().toString();
    }

    public void setResponse(String response) {
        //Display alert with response
        new AlertDialog.Builder(getActivity())
                .setTitle("Response")
                .setMessage(response)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }

                }).show();

        edt_txt_name.setText("");
        edt_txt_addr.setText("");
        edt_txt_phn.setText("");
    }


}
