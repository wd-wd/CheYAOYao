package com.lanxiang.cheyaoyao.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.domain.GoodsListData;

import java.util.List;

/**
 * Desc :商品列表
 * Created by WangDong on 2017/8/4.
 */

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsHolder> {
    private List<GoodsListData.ResultMapBean.ResultBean> mItems;
    @Override
    public GoodsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods, parent, false);
        GoodsHolder goodsHolder = new GoodsHolder(view);
        return goodsHolder;
    }

    @Override
    public void onBindViewHolder(GoodsHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mItems==null?0:mItems.size();
    }

    public void setItems(List<GoodsListData.ResultMapBean.ResultBean> items) {
        this.mItems = items;
        notifyDataSetChanged();
    }

    class GoodsHolder extends RecyclerView.ViewHolder{
        public GoodsHolder(View itemView) {
            super(itemView);
        }
    }
}
