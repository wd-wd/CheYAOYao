package com.lanxiang.cheyaoyao.ui.model.impl;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.Http.RetrofitClient;
import com.lanxiang.cheyaoyao.common.CYYConstants;
import com.lanxiang.cheyaoyao.domain.GoodsListData;
import com.lanxiang.cheyaoyao.ui.model.GoodsModel;
import com.lanxiang.cheyaoyao.utils.CommonCacheUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;


/**
 * Desc :商品model的实现类
 * Created by WangDong on 2017/8/4.
 */

public class GoodsModelImpl implements GoodsModel {

    @Override
    public Observable<GoodsListData> getNetData(String pageSize, String currentPageIndex) {
        RetrofitClient.initBaseUrl(CheYaoYaoApp.getsContext(), CYYConstants.SERVER_URL);
        Observable<GoodsListData> observable = RetrofitClient.getInstance().getCyyApi().getGoodsList1(pageSize, currentPageIndex);
        return observable;
    }

    @Override
    public void getNetData(String pageSize, String currentPageIndex, final OnListener onListener) {
        RetrofitClient.initBaseUrl(CheYaoYaoApp.getsContext(), CYYConstants.SERVER_URL);
        Call<GoodsListData> goodsList = RetrofitClient.getInstance().getCyyApi().getGoodsList(pageSize, currentPageIndex);
        goodsList.enqueue(new Callback<GoodsListData>() {
            @Override
            public void onResponse(Call<GoodsListData> call, Response<GoodsListData> response) {
                if (response.body() != null && response.code() == 200) {
                    String json = CheYaoYaoApp.getGson().toJson(response.body());
                    CommonCacheUtils.cacheToFile(json,"goodsList.do");
                    onListener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<GoodsListData> call, Throwable t) {
                onListener.onError(t.toString());
            }
        });
    }

    @Override
    public void getCacheData(String url, OnListener onListener) {
        String json = CommonCacheUtils.getLocalJson(url);
        GoodsListData goodsListData = CheYaoYaoApp.getGson().fromJson(json, GoodsListData.class);
        if (json!=null){
            onListener.onSuccess(goodsListData);
        }else {
            onListener.onError("无网络");
        }

    }

}
