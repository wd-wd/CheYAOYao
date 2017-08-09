package com.lanxiang.cheyaoyao.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.R;
import com.lanxiang.cheyaoyao.utils.GlideUtil;
import com.lanxiang.cheyaoyao.widget.CircleImageView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Desc :s视频列表的adpter
 * Created by WangDong on 2017/8/9.
 */

public class MovieListAdapter extends RecyclerView.Adapter {
    private List<String> mStringList;

    public MovieListAdapter(List<String> stringList) {
        this.mStringList = stringList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view0 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_image_list, parent, false);
                MovieImageListHolder movieImageListHolder = new MovieImageListHolder(view0);
                return movieImageListHolder;
            case 1:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_duanzi_list, parent, false);
                MovieDuanziListHolder movieDuanziListHolder = new MovieDuanziListHolder(view1);
                return movieDuanziListHolder;
            case 2:
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_gif_list, parent, false);
                MovieGifListHolder movieGifListHolder = new MovieGifListHolder(view2);
                return movieGifListHolder;
            case 3:
                View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_video_list, parent, false);
                MovieVideoListHolder movieVideoListHolder = new MovieVideoListHolder(view3);
                return movieVideoListHolder;

        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        String type = mStringList.get(position);
        switch (type) {
            case "image":
                return 0;
            case "text":
                return 1;
            case "gif":
                return 2;
            case "video":
                return 3;
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MovieVideoListHolder) {
            if (position == 0 | position == 5 | position == 8) {
                ((MovieVideoListHolder) holder).mCreateTime.setText("2017-08-09 10:49:07");
                ((MovieVideoListHolder) holder).mName.setText("吐嚎Video [一本道场]");
                ((MovieVideoListHolder) holder).mLike.setText("6");
                ((MovieVideoListHolder) holder).mUnLike.setText("12");
                GlideUtil.getInstance().loadImage(CheYaoYaoApp.getsContext(), ((MovieVideoListHolder) holder).mProfileImage,
                        "http://wimg.spriteapp.cn/profile/large/2017/05/16/591a9b554467f_mini.jpg", false);
                ((MovieVideoListHolder) holder).mVideo.setUp("http://wvideo.spriteapp.cn/video/2017/0809/598a76a518092_wpd.mp4"
                        , JCVideoPlayer.SCREEN_LAYOUT_LIST, "虽然天气很热，美女这样出门真的好吗？");
                GlideUtil.getInstance().loadImage(CheYaoYaoApp.getsContext(), ((MovieVideoListHolder) holder).mVideo.thumbImageView,
                        "http://wimg.spriteapp.cn/picture/2017/0809/598a76a50fbb3__b.jpg", false);
            }else {
                ((MovieVideoListHolder) holder).mCreateTime.setText("2017-08-09 09:43:41");
                ((MovieVideoListHolder) holder).mName.setText("相思明月楼 [百思跳跳鱼]");
                ((MovieVideoListHolder) holder).mLike.setText("3");
                ((MovieVideoListHolder) holder).mUnLike.setText("7");
                GlideUtil.getInstance().loadImage(CheYaoYaoApp.getsContext(), ((MovieVideoListHolder) holder).mProfileImage,
                        "http://wimg.spriteapp.cn/profile/large/2017/07/21/59721d2d246c4_mini.jpg", false);
                ((MovieVideoListHolder) holder).mVideo.setUp("http://wvideo.spriteapp.cn/video/2017/0809/598a652788d66_wpd.mp4"
                        , JCVideoPlayer.SCREEN_LAYOUT_LIST, "火红的裙子，白色的高跟鞋。这样的妹子姐夫们喜欢吗？");
                GlideUtil.getInstance().loadImage(CheYaoYaoApp.getsContext(), ((MovieVideoListHolder) holder).mVideo.thumbImageView,
                        "http://wimg.spriteapp.cn/picture/2017/0809/598a65277e01f__b.jpg", false);
            }
        }else if (holder instanceof MovieImageListHolder){
            ((MovieImageListHolder)holder).mCreateTime.setText("2017-08-09 12:32:40");
            ((MovieImageListHolder)holder).mName.setText("百思送葬队二大队队长");
            ((MovieImageListHolder)holder).mLike.setText("0");
            ((MovieImageListHolder)holder).mUnLike.setText("19");
            ((MovieImageListHolder)holder).mText.setText("刚刚相亲对象发了一张照片给我，，，姐夫们这门亲事我同意吗？？给个意见");
            GlideUtil.getInstance().loadImage(CheYaoYaoApp.getsContext(),((MovieImageListHolder)holder).mImage0,
                    "http://wimg.spriteapp.cn/crop/150x150/ugc/2017/08/09/598a861dcf346.jpg",false);
            GlideUtil.getInstance().loadImage(CheYaoYaoApp.getsContext(),((MovieImageListHolder)holder).mProfileImage,
                    "http://wimg.spriteapp.cn/profile/large/2017/06/30/595581a7f0807_mini.jpg",false);
        }
        else if (holder instanceof MovieGifListHolder){
            ((MovieGifListHolder)holder).mCreateTime.setText("2017-08-09 11:52:16");
            ((MovieGifListHolder)holder).mName.setText("搞笑内涵侠 [快乐驿站]");
            ((MovieGifListHolder)holder).mLike.setText("15");
            ((MovieGifListHolder)holder).mUnLike.setText("3");
            ((MovieGifListHolder)holder).mText.setText("昨天来应聘的秘书，今天来试一试，还别说，穿上这套衣服还真有点样子，就是不知道能干多久");
            GlideUtil.getInstance().loadGifThumbnailImage(CheYaoYaoApp.getsContext(),((MovieGifListHolder)holder).mImage0,
                    "http://wimg.spriteapp.cn/ugc/2017/08/09/598a5bb03ca49.gif");
          /*  Glide.with(CheYaoYaoApp.getsContext())
                    .load("http://wimg.spriteapp.cn/ugc/2017/08/09/598a5bb03ca49.gif").asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(((MovieGifListHolder) holder).mImage0);*/
            GlideUtil.getInstance().loadImage(CheYaoYaoApp.getsContext(),((MovieGifListHolder)holder).mProfileImage,
                    "http://wimg.spriteapp.cn/profile/large/2017/03/01/58b6ed2126d85_mini.jpg",false);
        }else if (holder instanceof MovieDuanziListHolder){
            ((MovieDuanziListHolder)holder).mCreateTime.setText("2017-07-29 14:23:07");
            ((MovieDuanziListHolder)holder).mName.setText("用户868567");
            ((MovieDuanziListHolder)holder).mLike.setText("93");
            ((MovieDuanziListHolder)holder).mUnLike.setText("12");
            ((MovieDuanziListHolder)holder).mContent.setText("租了辆奔驰，围着停车场转悠，" +
                    "看见一辆玛莎拉蒂要倒车入库，于是以迅雷不及掩耳盗铃儿响叮当之势把车直插入库，" +
                    "对方是个发福的中年男人，脖子上的金链子足有大拇指那么粗，对我说:“小伙子，你怎么回事啊，" +
                    "怎么抢我车位。”我从车里拿出事先准备好的一千块:“大哥，你还是再找个车位去吧！”他接过后:“行，那这个车位你停吧！");
            GlideUtil.getInstance().loadImage(CheYaoYaoApp.getsContext(),((MovieDuanziListHolder)holder).mProfileImage,
                    "http://wimg.spriteapp.cn/profile/large/2017/07/10/59636dc01b3e7_mini.jpg",false);
        }
    }

    @Override
    public int getItemCount() {
        return mStringList == null ? 0 : mStringList.size();
    }

    class MovieImageListHolder extends RecyclerView.ViewHolder {

        private final ImageView mImage0;
        private final TextView mText;
        private final TextView mName;
        private final CircleImageView mProfileImage;
        private final TextView mCreateTime;
        private final TextView mLike;
        private final TextView mUnLike;

        public MovieImageListHolder(View itemView) {

            super(itemView);
            mImage0 = (ImageView) itemView.findViewById(R.id.image0);
            mText = (TextView) itemView.findViewById(R.id.text);
            mName = (TextView) itemView.findViewById(R.id.name);
            mProfileImage = (CircleImageView) itemView.findViewById(R.id.profile_image);
            mCreateTime = (TextView) itemView.findViewById(R.id.create_time);
            mLike = (TextView) itemView.findViewById(R.id.like);
            mUnLike = (TextView) itemView.findViewById(R.id.unlike);
        }
    }

    class MovieDuanziListHolder extends RecyclerView.ViewHolder {
        private final TextView mContent;
        private final TextView mName;
        private final CircleImageView mProfileImage;
        private final TextView mCreateTime;
        private final TextView mLike;
        private final TextView mUnLike;
        public MovieDuanziListHolder(View itemView) {
            super(itemView);
            mContent = (TextView) itemView.findViewById(R.id.content);
            mName = (TextView) itemView.findViewById(R.id.name);
            mProfileImage = (CircleImageView) itemView.findViewById(R.id.profile_image);
            mCreateTime = (TextView) itemView.findViewById(R.id.create_time);
            mLike = (TextView) itemView.findViewById(R.id.like);
            mUnLike = (TextView) itemView.findViewById(R.id.unlike);
        }
    }

    class MovieGifListHolder extends RecyclerView.ViewHolder {
        private final ImageView mImage0;
        private final TextView mText;
        private final TextView mName;
        private final CircleImageView mProfileImage;
        private final TextView mCreateTime;
        private final TextView mLike;
        private final TextView mUnLike;
        public MovieGifListHolder(View itemView) {
            super(itemView);
            mImage0 = (ImageView) itemView.findViewById(R.id.image0);
            mText = (TextView) itemView.findViewById(R.id.text);
            mName = (TextView) itemView.findViewById(R.id.name);
            mProfileImage = (CircleImageView) itemView.findViewById(R.id.profile_image);
            mCreateTime = (TextView) itemView.findViewById(R.id.create_time);
            mLike = (TextView) itemView.findViewById(R.id.like);
            mUnLike = (TextView) itemView.findViewById(R.id.unlike);
        }
    }

    class MovieVideoListHolder extends RecyclerView.ViewHolder {

        private final JCVideoPlayerStandard mVideo;
        private final TextView mName;
        private final CircleImageView mProfileImage;
        private final TextView mCreateTime;
        private final TextView mLike;
        private final TextView mUnLike;

        public MovieVideoListHolder(View itemView) {
            super(itemView);
            mVideo = (JCVideoPlayerStandard) itemView.findViewById(R.id.video);
            mName = (TextView) itemView.findViewById(R.id.name);
            mProfileImage = (CircleImageView) itemView.findViewById(R.id.profile_image);
            mCreateTime = (TextView) itemView.findViewById(R.id.create_time);
            mLike = (TextView) itemView.findViewById(R.id.like);
            mUnLike = (TextView) itemView.findViewById(R.id.unlike);
        }
    }
}
