package com.lanxiang.cheyaoyao.Http;

import android.content.Context;

import com.apkfuns.logutils.LogUtils;
import com.lanxiang.cheyaoyao.utils.NetWorkUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Desc :
 * Created by WangDong on 2017/7/31.
 */

public class RspCacheControllerInterceptor implements Interceptor {
    //缓存缓存失效时间(两天)
    private final int maxTime = 60 * 60 * 24 * 2;//以秒为单位
    private Context mContext;

    public RspCacheControllerInterceptor(Context context) {
        this.mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();//获取请求
        //这里就是说判读我们的网络条件，要是有网络的话我就直接获取网络上面的数据，要是没有网络的话我么就去缓存里面取数据
        if(!NetWorkUtils.isNetworkConnected(mContext)){
            request = request.newBuilder()
                    //这个的话内容有点多啊，大家记住这么写就是只从缓存取
                    // 获取大家去找拦截器资料的时候就可以看到这个方面的东西反正也就是缓存策略。
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            LogUtils.d("RspCacheControllerInterceptor","no network");
        }
        Response originalResponse = chain.proceed(request);
        if(NetWorkUtils.isNetworkConnected(mContext)){
            //这里大家看点开源码看看.header .removeHeader做了什么操作很简单，就是的加字段和减字段的。
            String cacheControl = request.cacheControl().toString();
            return originalResponse.newBuilder()
                    //这里设置的为0就是说不进行缓存，我们也可以设置缓存时间
                    .header("Cache-Control", "public, max-age=" + 0)
                    .removeHeader("Pragma")
                    .build();
        }else{
            return originalResponse.newBuilder()
                    //这里的设置的是我们的没有网络的缓存时间，想设置多少就是多少。
                    .header("Cache-Control", "public, only-if-cached, max-stale="+maxTime)
                    .removeHeader("Pragma")
                    .build();
        }
    }
}
