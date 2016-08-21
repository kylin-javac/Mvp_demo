package com.ligang.mvp_demo.model;


public interface GetModel {
    void getModelData(completed completed,String path);
     interface  completed{
         void completedListern(String path,byte bs[]);
    }
}
