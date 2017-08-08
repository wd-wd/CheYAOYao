package com.lanxiang.cheyaoyao;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.mob.MobSDK;

import java.util.HashMap;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.ShareSDKR;

/**
 * Desc :
 * Created by WangDong on 2017/7/28.
 */

public class CheYaoYaoApp extends Application {
    private static Context sContext;
    // 缓存协议数据（json）
    private static HashMap<String, String> protocolCache;
    private static Gson gson;

    public static Context getsContext() {
        return sContext;
    }

    public static HashMap<String,String>getProtocolCache(){
        return protocolCache;
    }
    public static Gson getGson(){
        return gson;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        protocolCache = new HashMap<>();
        gson = new Gson();
        MobSDK.init(this);
    }
}
