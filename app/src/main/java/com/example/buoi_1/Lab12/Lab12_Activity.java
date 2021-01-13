package com.example.buoi_1.Lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.buoi_1.R;

public class Lab12_Activity extends AppCompatActivity {
    public static int TIME_OUT=3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab12_);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Lab12_Activity.this, Lab122Activity.class);
                startActivity(intent);
                finish();
            }
        },TIME_OUT);
    }
}
