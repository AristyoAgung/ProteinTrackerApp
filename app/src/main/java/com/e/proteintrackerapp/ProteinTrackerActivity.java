package com.e.proteintrackerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ProteinTrackerActivity extends AppCompatActivity {
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_protein);





        Button resetButton = (Button)findViewById(R.id.button4);
        resetButton.setOnClickListener(resetButtonListener);

        Button btnSetting = (Button)findViewById(R.id.button2);
        btnSetting.setOnClickListener(myBtnSettingClick);

        SharedPreferences prefs = ProteinTrackerActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);

        String statusLogin = prefs.getString("isLogin",null);
        Button btnLogin = (Button)findViewById(R.id.button3);

        btnLogin.setOnClickListener(myBtnLoginClick);

        if (statusLogin != null){
            btnLogin.setText("Logout");
        }else{
            btnLogin.setText("Login"); }
    }

    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            progressBar.setVisibility(View.GONE);
        }
    };

    private View.OnClickListener resetButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Intent intent = new Intent(ProteinTrackerActivity.this, SettingsProteinTracker.class);
            //startActivity(intent);
            AlertDialog.Builder builder = new AlertDialog.Builder(ProteinTrackerActivity.this);
            builder.setMessage("Apakah anda yakin untuk mereset nilai protein?")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(ProteinTrackerActivity.this, "Tidak jadi reset", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Toast.makeText(ProteinTrackerActivity.this, "Melakukan RESET !!", Toast.LENGTH_SHORT).show();
                            /*LinearLayout layout = findViewById(R.id.sap);

                            progressBar = new ProgressBar(ProteinTrackerActivity.this, null, android.R.attr.progressBarStyleLarge);
                            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
                            params.addRule(RelativeLayout.CENTER_IN_PARENT);
                            layout.addView(progressBar, params);

                            Thread thread = new Thread(new Runnable() {
                                public void run() {
                                    try {
                                        Thread.sleep(3000);
                                        handler.sendEmptyMessage(0);
                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                          e.printStackTrace();
                                    }
                                }
                            });

                                thread.start();
                                progressBar.setVisibility(View.VISIBLE);*/

                            final Dialog dialog1;
                            dialog1 = new Dialog(ProteinTrackerActivity.this);
                            dialog1.setContentView(R.layout.layout);
                            dialog1.setTitle("Custom Dialog");

                            Button btnDialog = (Button)dialog1.findViewById(R.id.button);
                            btnDialog.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    // TODO Auto-generated method stub
                                    dialog1.dismiss();
                                }
                            });

                                dialog1.show();
                            }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        };
    };

    private View.OnClickListener myBtnSettingClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ProteinTrackerActivity.this, SettingsProteinTracker.class);
            startActivity(intent);
        };
    };

    private View.OnClickListener myBtnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences prefs = ProteinTrackerActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);

        String statusLogin = prefs.getString("isLogin",null);
        SharedPreferences.Editor edit = prefs.edit();

        Button btnLogin = (Button)findViewById(R.id.button3);
        if (statusLogin != null){
            edit.putString("isLogin",null);
            btnLogin.setText("Login");
        }else{
            edit.putString("isLogin","Admin");
            btnLogin.setText("Logout");
        }
        edit.commit();
        }
    };
}
