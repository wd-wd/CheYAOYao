package com.lanxiang.cheyaoyao.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.domain.ActivityListData;

import java.util.List;

/**
 * Desc :
 * Created by WangDong on 2017/7/26.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private List<ActivityListData.DataBean.ItemsBean> mData;
    public MyAdapter(List<ActivityListData.DataBean.ItemsBean> data) {
        this.mData = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
