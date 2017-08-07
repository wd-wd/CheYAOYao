package com.lanxiang.cheyaoyao.common;

import com.lanxiang.cheyaoyao.domain.ActivityListData;
import com.lanxiang.cheyaoyao.domain.GoodsListData;
import com.lanxiang.cheyaoyao.domain.MovieTabListData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Desc :接口参数
 * Created by WangDong on 2017/7/27.
 */

 public interface CYYApi {
    @GET("queryMyComActivityByUserId.do")
    Call<ActivityListData> getActivityList(@Query("myFlag")String myFlag
            ,@Query("userid")String userid,@Query("currentPageIndex")String currentPageIndex);
    @GET("goodsList.do")
    Call<GoodsListData> getGoodsList(@Query("pageSize")String pageSize,@Query("currentPageIndex")String currentPageIndex);
   @GET("goodsList.do")
   Observable<GoodsListData> getGoodsList1(@Query("pageSize")String pageSize, @Query("currentPageIndex")String currentPageIndex);
    @GET("public/list-appbar/budejie-android-6.5.11/")
    Call<MovieTabListData> getMovieTabListData();
}
