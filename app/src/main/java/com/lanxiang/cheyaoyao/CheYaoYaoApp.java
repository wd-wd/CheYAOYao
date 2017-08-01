package com.lanxiang.cheyaoyao;

import android.app.Application;
import android.content.Context;

import java.util.HashMap;

/**
 * Desc :
 * Created by WangDong on 2017/7/28.
 */

public class CheYaoYaoApp extends Application {
    private static Context sContext;
    // 缓存协议数据（json）
    private static HashMap<String, String> protocolCache;

    public static Context getsContext() {
        return sContext;
    }

    public static HashMap<String,String>getProtocolCache(){
        return protocolCache;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        protocolCache = new HashMap<>();
    }
}
