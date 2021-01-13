package com.example.buoi_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Lab11_Activity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab11_);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(this);
    }

    private Bitmap loadImage(String link){
        URL url;
        Bitmap bmp = null;
        try {
            url = new URL(link);
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmp;
    }

    @Override
    public void onClick(View v) {
        final  Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadImage("https://ap.poly.edu.vn/images/logo.png");
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Image download");
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        });
        myThread.start();

    }
}