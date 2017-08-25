package com.lanxiang.cheyaoyao.ui.model;

import com.lanxiang.cheyaoyao.domain.GoodsListData;
import com.lanxiang.cheyaoyao.domain.VideoData;

import rx.Observable;

/**
 * Desc :视频列表
 * Created by WangDong on 2017/8/25.
 */

public interface VideoListModel {
    public Observable<VideoData> getVideoList(String showapi_appid,String showapi_sign,String type,String page);
    void getCacheData(String url,OnListener onListener);

    interface OnListener {
        void onSuccess(VideoData videoData);

        void onError(String errorMessage);
    }
}
