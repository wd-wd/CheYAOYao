package com.lanxiang.cheyaoyao.common;

import com.lanxiang.cheyaoyao.domain.ActivityListData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Desc :接口参数
 * Created by WangDong on 2017/7/27.
 */

 public interface CYYApi {
    @GET("queryMyComActivityByUserId.do")
    Call<ActivityListData> getActivityList(@Query("myFlag")String myFlag
            ,@Query("userid")String userid,@Query("currentPageIndex")String currentPageIndex);
}
