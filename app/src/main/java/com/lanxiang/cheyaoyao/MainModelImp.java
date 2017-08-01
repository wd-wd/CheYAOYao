package com.lanxiang.cheyaoyao;

import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.lanxiang.cheyaoyao.Http.GlobeHttpHandler;
import com.lanxiang.cheyaoyao.Http.RequestIntercept;
import com.lanxiang.cheyaoyao.Http.RspCacheControllerInterceptor;
import com.lanxiang.cheyaoyao.common.CYYApi;
import com.lanxiang.cheyaoyao.common.CYYConstants;
import com.lanxiang.cheyaoyao.domain.ActivityListData;
import com.lanxiang.cheyaoyao.utils.CommonCacheUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Desc :
 * Created by WangDong on 2017/7/28.
 */

public class MainModelImp implements MainModel {
    private static final String TAG = "MainModelImp";
    private Gson gson = new Gson();
    @Override
    public void getNetData(String myFlag, String userid, String currentPageIndex, final onListener listener) {
        File httpCacheDirectory = new File(Environment.getExternalStorageDirectory(), "HttpCache");//这里为了方便直接把文件放在了SD卡根目录的HttpCache中，一般放在context.getCacheDir()中
        int cacheSize = 10 * 1024 * 1024;//设置缓存文件大小为10M
        final Cache cache = new Cache(httpCacheDirectory, cacheSize);
        RspCacheControllerInterceptor rspCacheControllerInterceptor = new RspCacheControllerInterceptor(CheYaoYaoApp.getsContext());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder.retryOnConnectionFailure(true)//链接失败后是否重新连接
                .connectTimeout(12, TimeUnit.SECONDS)//连接超时时间12s
                .readTimeout(12, TimeUnit.SECONDS)//读取超时时间12s
                .writeTimeout(10, TimeUnit.SECONDS)//写入超时
//                .cache(cache)
//                .addNetworkInterceptor(rspCacheControllerInterceptor)
                .addInterceptor(getRequestIntercept())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CYYConstants.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        CYYApi cyyApi = retrofit.create(CYYApi.class);
        Call<ActivityListData> activityList = cyyApi.getActivityList(myFlag, userid, currentPageIndex);
        activityList.enqueue(new Callback<ActivityListData>() {
            @Override
            public void onResponse(Call<ActivityListData> call, Response<ActivityListData> response) {
                if (response.body() != null && response.code() == 200) {
                    String json = gson.toJson(response.body());
//                    Log.d(TAG, json);
                    CommonCacheUtils.cacheToFile(json,"queryMyComActivityByUserId.do");
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<ActivityListData> call, Throwable t) {
                listener.onFailed(t.toString());
            }
        });
    }

    @Override
    public void getCacheData(String url,onListener listener) {
        String json = CommonCacheUtils.getLocalJson(url);
        ActivityListData activityListData = gson.fromJson(json, ActivityListData.class);
        if (json!=null){
            listener.onSuccess(activityListData);
        }else {
            listener.onFailed("无网络");
        }
    }


    // 日志拦截器
    public RequestIntercept getRequestIntercept() {
        RequestIntercept requestIntercept = new RequestIntercept(new GlobeHttpHandler() {
            @Override
            public okhttp3.Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, okhttp3.Response response) {
                //这里可以比客户端提前一步拿到服务器返回的结果,可以做一些操作,比如token超时,重新获取
                return response;
            }

            @Override
            public Request onHttpRequestBefore(Interceptor.Chain chain, Request request) {
                //在请求服务器之前可以拿到request,做一些操作比如给request添加header,如果不做操作则返回参数中的request
                return request;
            }
        });
        return requestIntercept;
    }
}
