package com.lanxiang.cheyaoyao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.domain.ActivityListData;
import com.lanxiang.cheyaoyao.utils.GlideUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        holder.mName.setText(mData.get(position).activityTitle);
//        GlideUtil.getInstance().loadImage(mContext,holder.mPicture,mData.get(position).imagUrl,true);
//        GlideUtil.getInstance().loadThumbnailImage(mContext,holder.mPicture,mData.get(position).imagUrl);
        GlideUtil.getInstance().loadThumbnailImage(mContext,holder.mPicture,mData.get(position).imagUrl);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setItems(List<ActivityListData.DataBean.ItemsBean> items) {
        this.mData = items;
        notifyDataSetChanged();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView mPicture;
        private final ImageView mRightPicture;
        private final TextView mName;

        public MyHolder(View itemView) {
            super(itemView);
            mPicture = (ImageView) itemView.findViewById(R.id.iv_activity_picture);
            mRightPicture = (ImageView) itemView.findViewById(R.id.iv_activity_right);
            mName = (TextView) itemView.findViewById(R.id.tv_activity_name);
        }
    }
}
