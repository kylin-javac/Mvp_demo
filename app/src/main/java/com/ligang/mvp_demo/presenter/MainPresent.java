package com.ligang.mvp_demo.presenter;

import com.google.gson.Gson;
import com.ligang.mvp_demo.bean.ObjecytBean;
import com.ligang.mvp_demo.model.GetModel;
import com.ligang.mvp_demo.model.MainModel;
import com.ligang.mvp_demo.view.ShowView;

public class MainPresent {
    private ShowView view;
    private GetModel getModel;

    public MainPresent(ShowView view) {
        this.view = view;
        getModel=new MainModel();
    }

    public void getDataObject(String path){
        getModel.getModelData(new GetModel.completed() {
            @Override
            public void completedListern(String path, byte[] bs) {
                String json = new String(bs);
                ObjecytBean bean = new Gson().fromJson(json, ObjecytBean.class);
                view.showData(bean);
            }
        }, path);
    }
}
