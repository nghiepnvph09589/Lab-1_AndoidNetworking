package com.example.buoi_1.Lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buoi_1.R;

import org.apache.http.params.HttpConnectionParams;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Lab122Activity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private Button buttonLoad;
    private TextView textView;
    private String url = "https://ap.poly.edu.vn/images/logo.png";
    private Bitmap bitmap = null;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab122);
        imageView = findViewById(R.id.imageView);
        buttonLoad = findViewById(R.id.buttonLoad);
        textView = findViewById(R.id.tvMessage);
        buttonLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        progressDialog = ProgressDialog.show(Lab122Activity.this, "Đang download", "Đang download");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                   bitmap = downloadBitmap(url);
                   Message msg = messageHandler.obtainMessage();
                   Bundle bundle = new Bundle();
                   String thMessage = "đã xong";
                   bundle.putString("Message",thMessage);
                   msg.setData(bundle);
                   messageHandler.sendMessage(msg);
            }
        };
        Thread th = new Thread(runnable);
        th.start();
    }
    private Handler messageHandler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String message = bundle.getString("Message");
            textView.setText(message);
            imageView.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };
    private  Bitmap downloadBitmap(String link)
    {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}