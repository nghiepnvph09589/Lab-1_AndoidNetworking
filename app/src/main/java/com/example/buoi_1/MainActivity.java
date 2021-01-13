package com.example.buoi_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.buoi_1.Lab12.Lab12_Activity;
import com.example.buoi_1.Lab13.Lab13_Async_Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bai1(View view) {
        Intent intent = new Intent(MainActivity.this, Lab11_Activity.class);
        startActivity(intent);
    }

    public void bai2(View view) {
        Intent intent = new Intent(MainActivity.this, Lab12_Activity.class);
        startActivity(intent);
    }

    public void bai3(View view) {
        Intent intent = new Intent(MainActivity.this, Lab13_Async_Activity.class);
        startActivity(intent);
    }
}