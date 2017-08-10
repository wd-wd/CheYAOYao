package com.lanxiang.cheyaoyao.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.R;

import java.util.List;

/**
 * Desc :
 * Created by WangDong on 2017/8/10.
 */

public class HomeFenleiAdapter extends RecyclerView.Adapter<HomeFenleiAdapter.FenleiGrideHolder> {
    private List<String> mFenleiData;
   private List<Integer> mImages;

    public HomeFenleiAdapter(List<String> fenleiData, List<Integer> images) {
        this.mFenleiData = fenleiData;
        this.mImages = images;
    }

    @Override
    public FenleiGrideHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_fenlei_in, parent, false);
        FenleiGrideHolder fenleiGrideHolder = new FenleiGrideHolder(view);
        return fenleiGrideHolder;
    }

    @Override
    public void onBindViewHolder(FenleiGrideHolder holder, final int position) {
        holder.mIv_home_fenlei.setImageResource(mImages.get(position));
        holder.mTv_home_fenlei.setText(mFenleiData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CheYaoYaoApp.getsContext(), mFenleiData.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFenleiData == null ? 0 : mFenleiData.size();
    }

    class FenleiGrideHolder extends RecyclerView.ViewHolder {

        private final ImageView mIv_home_fenlei;
        private final TextView mTv_home_fenlei;

        public FenleiGrideHolder(View itemView) {
            super(itemView);
            mIv_home_fenlei = (ImageView) itemView.findViewById(R.id.iv_home_fenlei);
            mTv_home_fenlei = (TextView) itemView.findViewById(R.id.tv_home_fenlei);
        }
    }
}
