package com.example.buoi_1.Lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buoi_1.R;

public class Lab13_Async_Activity extends AppCompatActivity implements View.OnClickListener,Bai3In {
    TextView textView;
    Button button;
    ImageView imageView;
    public static  final String StrImg = "https://kenh14cdn.com/zoom/460_289/203336854389633024/2021/1/6/photo1609942522021-16099425240381250340500.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1__async_);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.lab1img);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                new Bai3Async(this, Lab13_Async_Activity.this).execute((StrImg));
                break;
        }

    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
        textView.setText("complete");
    }

    @Override
    public void onError() {
        textView.setText("loi");
    }
}