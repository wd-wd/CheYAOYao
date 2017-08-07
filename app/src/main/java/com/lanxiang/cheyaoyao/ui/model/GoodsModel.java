package com.lanxiang.cheyaoyao.ui.model;

import com.lanxiang.cheyaoyao.domain.GoodsListData;

import rx.Observable;

/**
 * Desc :
 * Created by WangDong on 2017/8/4.
 */

public interface GoodsModel {
    Observable<GoodsListData> getNetData(String pageSize, String currentPageIndex);
    void getNetData(String pageSize, String currentPageIndex, OnListener onListener);

    void getCacheData(String url,OnListener onListener);

    interface OnListener {
        void onSuccess(GoodsListData goodsListData);

        void onError(String errorMessage);
    }
}
