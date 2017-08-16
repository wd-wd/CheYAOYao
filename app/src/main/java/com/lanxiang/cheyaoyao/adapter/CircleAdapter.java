package com.lanxiang.cheyaoyao.adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanxiang.cheyaoyao.R;

import java.util.List;

/**
 * Desc :
 * Created by WangDong on 2017/8/16.
 */

public class CircleAdapter extends RecyclerView.Adapter<CircleAdapter.CircleHolder> {
    private List<String> datas;

    public CircleAdapter(List<String> datas) {
        this.datas = datas;
    }

    @Override
    public CircleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_circle, parent, false);
        return new CircleHolder(view);
    }

    @Override
    public void onBindViewHolder(CircleHolder holder, int position) {
        holder.mTvItemChat.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class CircleHolder extends RecyclerView.ViewHolder {

        private final ImageView mIvItemChat;
        private final TextView mTvItemChat;

        public CircleHolder(View itemView) {
            super(itemView);
            mIvItemChat = (ImageView) itemView.findViewById(R.id.iv_item_chat);
            mTvItemChat = (TextView) itemView.findViewById(R.id.tv_item_chat);
        }
    }
}
