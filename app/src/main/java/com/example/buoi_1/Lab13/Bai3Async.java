package com.example.buoi_1.Lab13;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Bai3Async extends AsyncTask<String, Void, Bitmap> {
    Bai3In mListerner;
    private ProgressDialog progressDialog;

    public Bai3Async(View.OnClickListener listerner, Context context) {
        this.mListerner = (Bai3In) listerner;
        progressDialog = new ProgressDialog(context);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Download....");
        progressDialog.show();
    }
    //excute on server (phuong thuc thực hiện)
    @Override
    protected Bitmap doInBackground(String... strings) {
        try{
           return BitmapFactory.decodeStream((InputStream) new URL(strings[0]).getContent());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //posting data on Client
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        if (bitmap !=null){
          mListerner.onImageLoaded(bitmap);
        }
        else
        {
            mListerner.onError();
        }
    }
}
