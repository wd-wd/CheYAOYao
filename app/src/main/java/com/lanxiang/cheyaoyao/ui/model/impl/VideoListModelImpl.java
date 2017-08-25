package com.lanxiang.cheyaoyao.ui.model.impl;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.Http.RetrofitClient;
import com.lanxiang.cheyaoyao.common.CYYConstants;
import com.lanxiang.cheyaoyao.domain.GoodsListData;
import com.lanxiang.cheyaoyao.domain.VideoData;
import com.lanxiang.cheyaoyao.ui.model.GoodsModel;
import com.lanxiang.cheyaoyao.ui.model.VideoListModel;
import com.lanxiang.cheyaoyao.utils.CommonCacheUtils;

import rx.Observable;

/**
 * Desc :实现类
 * Created by WangDong on 2017/8/25.
 */

public class VideoListModelImpl implements VideoListModel {
    @Override
    public Observable<VideoData> getVideoList(String showapi_appid,String showapi_sign,String type,String page) {
        RetrofitClient.initBaseUrl(CheYaoYaoApp.getsContext(), CYYConstants.VIDEO_URL);
        Observable<VideoData> videoListData = RetrofitClient.getInstance().getCyyApi().getVideoListData(showapi_appid, showapi_sign, type, page);
        return videoListData;
    }

    @Override
    public void getCacheData(String url, VideoListModel.OnListener onListener) {
        String json = CommonCacheUtils.getLocalJson(url);
        VideoData videoData = CheYaoYaoApp.getGson().fromJson(json, VideoData.class);
        if (json!=null){
            onListener.onSuccess(videoData);
        }else {
            onListener.onError("无网络");
        }
    }
}
