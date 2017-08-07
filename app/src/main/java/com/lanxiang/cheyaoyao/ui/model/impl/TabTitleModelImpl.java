package com.lanxiang.cheyaoyao.ui.model.impl;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.Http.RetrofitClient;
import com.lanxiang.cheyaoyao.common.CYYApi;
import com.lanxiang.cheyaoyao.common.CYYConstants;
import com.lanxiang.cheyaoyao.domain.MovieTabListData;
import com.lanxiang.cheyaoyao.ui.model.TabTitleModel;
import com.lanxiang.cheyaoyao.utils.CommonCacheUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Desc :视频tabTitle实现类
 * Created by WangDong on 2017/8/5.
 */

public class TabTitleModelImpl implements TabTitleModel {
    @Override
    public void getTabTitleData(final OnListener onListener) {
        RetrofitClient.initBaseUrl(CheYaoYaoApp.getsContext(), CYYConstants.BAISI_URL);
        CYYApi cyyApi = RetrofitClient.getInstance().getCyyApi();
        Call<MovieTabListData> movieTabListData = cyyApi.getMovieTabListData();
        movieTabListData.enqueue(new Callback<MovieTabListData>() {
            @Override
            public void onResponse(Call<MovieTabListData> call, Response<MovieTabListData> response) {
                if (response.body() != null && response.code() == 200) {
                    String json = CheYaoYaoApp.getGson().toJson(response.body());
                    CommonCacheUtils.cacheToFile(json, "movieTabTitle.do");
                    onListener.onsuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieTabListData> call, Throwable t) {
                onListener.onError(t.toString());
            }
        });
    }

    @Override
    public void getCacheData(OnListener onListener) {
        String json = CommonCacheUtils.getLocalJson("movieTabTitle.do");
        if (json!=null){
            MovieTabListData movieTabListData = CheYaoYaoApp.getGson().fromJson(json, MovieTabListData.class);
            onListener.onsuccess(movieTabListData);
        }
    }
}
