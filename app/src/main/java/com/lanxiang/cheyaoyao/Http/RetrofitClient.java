package com.lanxiang.cheyaoyao.Http;

import android.content.Context;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.common.CYYApi;
import com.lanxiang.cheyaoyao.common.CYYConstants;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Desc :retrofit的封装
 * Created by WangDong on 2017/8/4.
 */

public class RetrofitClient {

    private final OkHttpClient mOkHttpClient;
    private final Retrofit mRetrofit;
    private final CYYApi mCyyApi;
    private static RetrofitClient retrofitClient;
    private static String mBaseUrl;
    private static Context mContext;

    public RetrofitClient(String baseUrl) {
        mOkHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(getRequestIntercept())
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mCyyApi = mRetrofit.create(CYYApi.class);
    }

    public static RetrofitClient getInstance() {
        if (retrofitClient == null) {
            synchronized (Objects.class) {
                if (retrofitClient == null) {
                    retrofitClient = new RetrofitClient(mBaseUrl);
                }
            }
        }
        return retrofitClient;
    }

    public static void initBaseUrl(Context context, String baseUrl) {
        mBaseUrl = baseUrl;
        mContext = context;
    }

    public CYYApi getCyyApi() {
        return mCyyApi;
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
