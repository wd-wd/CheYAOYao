package com.lanxiang.cheyaoyao.Http;

import android.support.annotation.NonNull;

import com.apkfuns.logutils.LogUtils;
import com.lanxiang.cheyaoyao.utils.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;


/**
 * Created by jess on 7/1/16.
 */
public class RequestIntercept implements Interceptor {
    private GlobeHttpHandler mHandler;

    public RequestIntercept(GlobeHttpHandler handler) {
        this.mHandler = handler;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (mHandler != null)//在请求服务器之前可以拿到request,做一些操作比如给request添加header,如果不做操作则返回参数中的request
            request = mHandler.onHttpRequestBefore(chain, request);
        Buffer requestBuffer = new Buffer();
        if (request.body() != null) {
            request.body().writeTo(requestBuffer);
        } else {
            LogUtils.d("request.body() == null");
        }
        //打印url信息
        LogUtils.d("Sending Request %s on %n Params --->  %s%n Connection ---> %s%n Headers ---> %s", request.url()
                , request.body() != null ? parseParams(request.body(), requestBuffer) : "null"
                , chain.connection()
                , request.headers());
        long t1 = System.nanoTime();
        Response originalResponse = chain.proceed(request);
        long t2 = System.nanoTime();
        //打印响应时间
        LogUtils.d("Received response  in %.1fms%n%s", (t2 - t1) / 1e6d, originalResponse.headers());
        //读取服务器返回的结果
        ResponseBody responseBody = originalResponse.body();
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        Buffer clone = buffer.clone();
        //解析response content
        Charset charset = Charset.forName("UTF-8");
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(charset);
        }
        String bodyString = clone.readString(charset);
        LogUtils.d("%s", StringUtils.jsonFormat(bodyString));
        if (mHandler != null)//这里可以比客户端提前一步拿到服务器返回的结果,可以做一些操作,比如token超时,重新获取
            return mHandler.onHttpResultResponse(bodyString, chain, originalResponse);
        return originalResponse;
    }

    @NonNull
    public static String parseParams(RequestBody body, Buffer requestbuffer) throws UnsupportedEncodingException {
        if (!body.contentType().toString().contains("multipart")) {
            return URLDecoder.decode(requestbuffer.readUtf8(), "UTF-8");
        }
        return "null";
    }

}
