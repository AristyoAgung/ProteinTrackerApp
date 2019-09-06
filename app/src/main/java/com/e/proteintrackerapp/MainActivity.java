package com.e.proteintrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener tableButtonListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TableLayoutActivity.class);
                startActivity(intent);
            }
        };
        Button tableBtn = (Button)findViewById(R.id.buttonTable);
        tableBtn.setOnClickListener(tableButtonListener);
        View.OnClickListener proteinButtonListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProteinTrackerActivity.class);
                startActivity(intent);
            }
        };
        Button proteinBtn = (Button)findViewById(R.id.buttonProtein);
        proteinBtn.setOnClickListener(proteinButtonListener);
    }
}
