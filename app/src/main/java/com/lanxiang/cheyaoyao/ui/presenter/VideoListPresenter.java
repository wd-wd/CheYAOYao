package com.lanxiang.cheyaoyao.ui.presenter;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.base.presenter.BasePresenter;
import com.lanxiang.cheyaoyao.base.view.MvpView;
import com.lanxiang.cheyaoyao.domain.GoodsListData;
import com.lanxiang.cheyaoyao.domain.VideoData;
import com.lanxiang.cheyaoyao.ui.model.GoodsModel;
import com.lanxiang.cheyaoyao.ui.model.VideoListModel;
import com.lanxiang.cheyaoyao.utils.CommonCacheUtils;
import com.lanxiang.cheyaoyao.utils.NetWorkUtils;

import rx.Subscriber;

/**
 * Desc :
 * Created by WangDong on 2017/8/25.
 */

public class VideoListPresenter extends BasePresenter<VideoListModel, MvpView<VideoData>, VideoData> implements VideoListModel.OnListener {
    public VideoListPresenter(VideoListModel model, MvpView<VideoData> view) {
        super(model, view);
    }

    public void getVideoList(String showapi_appid, String showapi_sign, String type, String page) {
        getView().showLoadingView();
        if (NetWorkUtils.isNetworkConnected(CheYaoYaoApp.getsContext())) {
            addSubscription(getModel().getVideoList(showapi_appid, showapi_sign, type, page), new Subscriber<VideoData>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    getView().showErrorView();
                }

                @Override
                public void onNext(VideoData videoData) {
                    if (videoData != null) {
                        String json = CheYaoYaoApp.getGson().toJson(videoData);
                        CommonCacheUtils.cacheToFile(json, "videolist.do");
                        if (videoData.showapiResBody.pagebean.contentlist != null && videoData.showapiResBody.pagebean.contentlist.size() > 0) {
                            getView().showSuccessContentView();
                        } else {
                            getView().showSuccessEmptyView();
                        }
                        getView().setData(videoData);
                    }
                }
            });
        }else {
            getModel().getCacheData("videolist.do",this);
        }
    }

    @Override
    public void onSuccess(VideoData videoData) {
        if (videoData != null) {
            if (videoData.showapiResBody.pagebean.contentlist != null && videoData.showapiResBody.pagebean.contentlist.size() > 0) {
                getView().showSuccessContentView();
            } else {
                getView().showSuccessEmptyView();
            }
            getView().setData(videoData);
        }
    }

    @Override
    public void onError(String errorMessage) {
        getView().showErrorView();
    }
}
