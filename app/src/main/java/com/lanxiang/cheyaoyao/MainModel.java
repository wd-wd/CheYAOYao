package com.lanxiang.cheyaoyao;

import com.lanxiang.cheyaoyao.domain.ActivityListData;

/**
 * Desc :
 * Created by WangDong on 2017/7/28.
 */

public interface MainModel {
    void getNetData(String myFlag, String userid, String currentPageIndex, onListener listener);
    void getCacheData(String url,onListener listener);
    interface onListener {
        void onSuccess(ActivityListData activityListData);

        void onFailed(String errorMessage);
    }
}
