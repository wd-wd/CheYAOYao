package com.lanxiang.cheyaoyao.ui.model;

import com.lanxiang.cheyaoyao.domain.MovieTabListData;

/**
 * Desc :视频tabTitle
 * Created by WangDong on 2017/8/5.
 */

public interface TabTitleModel {
    void getTabTitleData(OnListener onListener);
    void getCacheData(OnListener onListener);
    interface OnListener{
        void onsuccess(MovieTabListData movieTabListData);
        void onError(String errorMassage);
    }
}
