package com.lanxiang.cheyaoyao.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.domain.VideoData;
import com.lanxiang.cheyaoyao.utils.DateUtils;
import com.lanxiang.cheyaoyao.utils.GlideUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerSimple;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Desc :
 * Created by WangDong on 2017/8/24.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {
    private List<VideoData.ShowapiResBodyBean.PagebeanBean.ContentlistBean> mItem;
    private Context mContext;

    public VideoAdapter(Context context) {
        mContext = context;
    }

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        GlideUtil.getInstance().loadCircleImage(CheYaoYaoApp.getsContext(), holder.mIvHeadIcon, mItem.get(position).profileImage);
        holder.mTvHeadName.setText(mItem.get(position).name);
        holder.mLike.setText(mItem.get(position).love);
        holder.mUnlike.setText(mItem.get(position).hate);
        holder.mJcVideo.setUp(mItem.get(position).videoUri, JCVideoPlayer.SCREEN_LAYOUT_LIST, mItem.get(position).text.trim());
        GlideUtil.getInstance().loadImage(CheYaoYaoApp.getsContext(), holder.mJcVideo.thumbImageView, mItem.get(position).profileImage, false);
        holder.mTvVideoTime.setText(DateUtils.friendlyTime(mItem.get(position).createTime));
    }

    @Override
    public int getItemCount() {
        return mItem == null ? 0 : mItem.size();
    }

    public void setItem(List<VideoData.ShowapiResBodyBean.PagebeanBean.ContentlistBean> item) {
        mItem = item;
        notifyDataSetChanged();
    }

    class VideoHolder extends RecyclerView.ViewHolder {

        private final ImageView mIvHeadIcon;
        private final TextView mTvHeadName;
        private final TextView mLike;
        private final TextView mUnlike;
        private final JCVideoPlayerStandard mJcVideo;
        private final TextView mTvVideoTime;

        public VideoHolder(View itemView) {
            super(itemView);
            mIvHeadIcon = (ImageView) itemView.findViewById(R.id.iv_head_icon);
            mTvHeadName = (TextView) itemView.findViewById(R.id.tv_head_name);
            mLike = (TextView) itemView.findViewById(R.id.like);
            mUnlike = (TextView) itemView.findViewById(R.id.unlike);
            mJcVideo = (JCVideoPlayerStandard) itemView.findViewById(R.id.jc_video);
            mTvVideoTime = (TextView) itemView.findViewById(R.id.tv_video_time);
        }
    }
}
