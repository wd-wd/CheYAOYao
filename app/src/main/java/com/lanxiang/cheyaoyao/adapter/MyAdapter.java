package com.lanxiang.cheyaoyao.adapter;

import android.content.Context;
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
    private Context mContext;

    public MyAdapter(Context context) {
        this.mContext = context;
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

    public void setItems(List<ActivityListData.DataBean.ItemsBean> items) {
        this.mData = items;
        notifyDataSetChanged();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
