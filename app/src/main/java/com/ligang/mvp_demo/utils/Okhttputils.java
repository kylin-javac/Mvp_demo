package com.ligang.mvp_demo.utils;

import com.ligang.mvp_demo.model.GetModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Okhttputils {
    private GetModel.completed completed;
    private String path;
    OkHttpClient okHttpClient = new OkHttpClient();

    public Okhttputils(GetModel.completed completed, String path) {
        this.path = path;
        this.completed = completed;
    }

    public void getOkHttputils() {
        final Request request = new Request.Builder().url(path).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null && response.isSuccessful()) {
                 completed.completedListern(path,response.body().bytes());
                }
            }
        });

    }
}
