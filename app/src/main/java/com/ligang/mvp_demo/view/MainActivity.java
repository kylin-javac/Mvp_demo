package com.ligang.mvp_demo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.ligang.mvp_demo.R;
import com.ligang.mvp_demo.adapter.MyrecycleAdapter;
import com.ligang.mvp_demo.bean.ObjecytBean;
import com.ligang.mvp_demo.presenter.MainPresent;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ShowView<ObjecytBean> {
    public static final String PATH = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/5";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        new MainPresent(this).getDataObject(PATH);
    }

    @Override
    public void showData(ObjecytBean bean) {
        List<ObjecytBean.ResultsBean> results = bean.getResults();
        final MyrecycleAdapter adapter = new MyrecycleAdapter(MainActivity.this, results);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(adapter);
            }
        });

    }
}
