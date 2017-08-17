package com.lanxiang.cheyaoyao;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.mob.MobSDK;

import java.util.HashMap;

import cn.bmob.v3.Bmob;


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
        MobSDK.init(sContext, "20058664c8e5e", "5fba7f92225f69217f7af93e537081cc");
        iniBmob();
    }

    private void iniBmob() {
        Bmob.initialize(this,"eebb0138aa990046b24603b53c2b1520");
    }

}
