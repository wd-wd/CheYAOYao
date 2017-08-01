package com.lanxiang.cheyaoyao.utils;

import com.lanxiang.cheyaoyao.CheYaoYaoApp;
import com.lanxiang.cheyaoyao.common.CYYConstants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Desc :公共的缓存工具类,流程
 * Created by WangDong on 2017/8/1.
 */

public class CommonCacheUtils {
    /**
     * 从手机本地获取数据，包括内存和本地文件
     * @param url
     * @return
     */
    public static String getLocalJson(String url) {
        String json = getFromMemory(url);
        if (json == null) {
            json = getFromFile(url);
        }
        return json;
    }

    /**
     * 内存中读取数据
     * @param url
     * @return
     */
    public static String getFromMemory(String url){
        String json = CheYaoYaoApp.getProtocolCache().get(url);
        return json;
    }

    /**
     * 从文件中获取数据
     * @param url
     * @return
     */
    public static String getFromFile(String url){
        //读取本地文件
        //应用的缓存文件会存放在两个地方：
        //1.data/data/包名/cache  2.sdcard/android/data/包名/
        //存放的原则：1.中空间宝贵，如果文件大的话不建议存储其中
        String filePath = FileUtils.getDir("json");
        File file = new File(filePath, url);
        if (file.exists()) {
            //判断文件是否过时
            //如果文件过时，当前系统时间，获取俩时间差，与设置好的过时时间进行比对
            //约定文件存储格式及内容
            //文件第一行放系统当前时间，第二行放字符串

            try {
                FileReader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String timeStr = bufferedReader.readLine();
                long createTime = Long.valueOf(timeStr);
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis - createTime) < CYYConstants.DURATION) {
                    String json = bufferedReader.readLine();
                 CheYaoYaoApp.getProtocolCache().put(url, json);
                    return json;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return CheYaoYaoApp.getProtocolCache().get(url);
    }
    /**
     * 缓存网络数据到本地
     * @param json
     * @param url
     */
    public static void cacheToFile(String json,String url){
        //需要在内存中存一份
        CheYaoYaoApp.getProtocolCache().put(url,json);
        String filePath = FileUtils.getDir("json");
        //需要在本地存一份
        File file = new File(filePath,url);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(System.currentTimeMillis()+"");
            bufferedWriter.newLine();
            bufferedWriter.write(json);
            bufferedWriter.flush();
            IOUtils.close(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
