package com.ligang.mvp_demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ligang.mvp_demo.R;
import com.ligang.mvp_demo.bean.ObjecytBean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyrecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<ObjecytBean.ResultsBean> list;

    /**
     * 构造方法
     *
     * @param context 上下文
     * @param list    数据源
     */
    public MyrecycleAdapter(Context context, List<ObjecytBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new LgViewHold(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ObjecytBean.ResultsBean newsBean = list.get(position);
        LgViewHold lgViewHold = (LgViewHold) holder;
        lgViewHold.tex.setText(newsBean.getDesc());
        Picasso.with(context).load(newsBean.getUrl()).into(lgViewHold.img);

    }


    /**
     * 正文的布局
     */
    class LgViewHold extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tex;

        public LgViewHold(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            tex = (TextView) itemView.findViewById(R.id.title);
        }
    }


}