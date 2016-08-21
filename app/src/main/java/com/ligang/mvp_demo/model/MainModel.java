package com.ligang.mvp_demo.model;

import com.ligang.mvp_demo.utils.Okhttputils;

public class MainModel implements GetModel {
    @Override
    public void getModelData(completed completed, String path) {
        Okhttputils okhttputils = new Okhttputils(completed, path);
        okhttputils.getOkHttputils();
    }
}

