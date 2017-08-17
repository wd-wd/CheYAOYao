package com.lanxiang.cheyaoyao.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Desc :商品列表的数据
 * Created by WangDong on 2017/8/4.
 */

public class GoodsListData {


    /**
     * resultMap : {"result":[{"id":21,"goodsName":"eeee","goodsNum":21213,"goodsIntegral":2222,"imageUrl":"http://192.168.1.242:8889/static/upload/images/goods/20170801/cdfa24e6-4d7d-4e92-9b75-e5eaa138719f93821.png","isDisplay":-1,"status":1,"createTime":"2017-08-01 16:12:44","createUserId":32,"lastModifyTime":"2017-08-01 16:12:44","lastModifyUserId":32,"statusName":"上架","displayName":"","takeAddress":"22223213","goodsImage":"/images/goods/20170801/3c0325bd-e23d-4d44-9a42-41e1193c464335971.png","goodsPhone":"23213123","goodsContent":"23213232123232321321321321213213213213213213","hotFlag":2,"goodsSavo":0},{"id":20,"goodsName":"测试6","goodsNum":0,"goodsIntegral":1,"imageUrl":"http://192.168.1.242:8889/static/upload/images/goods/20170726/b2c48a8e-5bee-426a-9cfa-26352c683b5f22141.png","isDisplay":-1,"status":1,"createTime":"2017-07-26 17:31:01","createUserId":32,"lastModifyTime":"2017-08-01 15:16:20","lastModifyUserId":32,"statusName":"上架","displayName":"","takeAddress":"33333","goodsImage":"/images/goods/20170726/a65b66f5-29ee-495b-9b56-b9c719829e4900767.png","goodsPhone":"3333322222","goodsContent":"4热热热快捷回复即可撒谎飞机开发环境开放接口和","hotFlag":1,"goodsSavo":0},{"id":19,"goodsName":"测试5","goodsNum":0,"goodsIntegral":1,"imageUrl":"http://192.168.1.242:8889/static/upload/images/goods/20170726/1e9d4ee7-2913-4c55-87f4-0f3f386c2e5436879.png","isDisplay":-1,"status":1,"createTime":"2017-07-26 17:30:02","createUserId":32,"lastModifyTime":"2017-08-02 13:15:00","lastModifyUserId":-1,"statusName":"上架","displayName":"","takeAddress":"11111111","goodsImage":"/images/goods/20170726/498f6fd9-9707-4c47-8997-b8b7c5e225d940768.png","goodsPhone":"11111111","goodsContent":"1111111","hotFlag":1,"goodsSavo":0},{"id":17,"goodsName":"测试2","goodsNum":203,"goodsIntegral":10000,"imageUrl":"http://192.168.1.242:8889/static/upload/images/goods/20170724/fdb378f2-e68c-41bb-973c-74969b7fb19837679.png","isDisplay":-1,"status":1,"createTime":"2017-07-22 09:36:48","createUserId":32,"lastModifyTime":"2017-07-26 08:51:45","lastModifyUserId":-1,"statusName":"上架","displayName":"","takeAddress":"上海嘉定金园五路333","goodsImage":"/images/goods/20170724/3448b6c0-c07b-416d-9fa8-0ef9c8a724c824795.png","goodsPhone":"15564664651","goodsContent":"22222222222222222221321321321321211313","hotFlag":1,"goodsSavo":0},{"id":16,"goodsName":"测试1","goodsNum":177,"goodsIntegral":11,"imageUrl":"http://192.168.1.242:8889/static/upload/images/goods/20170724/623749da-39cd-42e1-a583-c845cef3f15141605.png","isDisplay":-1,"status":1,"createTime":"2017-07-13 09:11:12","createUserId":32,"lastModifyTime":"2017-07-26 17:28:36","lastModifyUserId":-1,"statusName":"上架","displayName":"","takeAddress":"上海嘉定1111111","goodsImage":"/images/goods/20170724/a59bf2e8-3cb1-40eb-ba89-064c4cf2663196785.png","goodsPhone":"11","goodsContent":"22222","hotFlag":1,"goodsSavo":0}],"count":4}
     * msg :
     * resultCode : 0
     */

    @SerializedName("resultMap")
    public ResultMapBean resultMap;
    @SerializedName("msg")
    public String msg;
    @SerializedName("resultCode")
    public String resultCode;

    public static class ResultMapBean {
        /**
         * result : [{"id":21,"goodsName":"eeee","goodsNum":21213,"goodsIntegral":2222,"imageUrl":"http://192.168.1.242:8889/static/upload/images/goods/20170801/cdfa24e6-4d7d-4e92-9b75-e5eaa138719f93821.png","isDisplay":-1,"status":1,"createTime":"2017-08-01 16:12:44","createUserId":32,"lastModifyTime":"2017-08-01 16:12:44","lastModifyUserId":32,"statusName":"上架","displayName":"","takeAddress":"22223213","goodsImage":"/images/goods/20170801/3c0325bd-e23d-4d44-9a42-41e1193c464335971.png","goodsPhone":"23213123","goodsContent":"23213232123232321321321321213213213213213213","hotFlag":2,"goodsSavo":0},{"id":20,"goodsName":"测试6","goodsNum":0,"goodsIntegral":1,"imageUrl":"http://192.168.1.242:8889/static/upload/images/goods/20170726/b2c48a8e-5bee-426a-9cfa-26352c683b5f22141.png","isDisplay":-1,"status":1,"createTime":"2017-07-26 17:31:01","createUserId":32,"lastModifyTime":"2017-08-01 15:16:20","lastModifyUserId":32,"statusName":"上架","displayName":"","takeAddress":"33333","goodsImage":"/images/goods/20170726/a65b66f5-29ee-495b-9b56-b9c719829e4900767.png","goodsPhone":"3333322222","goodsContent":"4热热热快捷回复即可撒谎飞机开发环境开放接口和","hotFlag":1,"goodsSavo":0},{"id":19,"goodsName":"测试5","goodsNum":0,"goodsIntegral":1,"imageUrl":"http://192.168.1.242:8889/static/upload/images/goods/20170726/1e9d4ee7-2913-4c55-87f4-0f3f386c2e5436879.png","isDisplay":-1,"status":1,"createTime":"2017-07-26 17:30:02","createUserId":32,"lastModifyTime":"2017-08-02 13:15:00","lastModifyUserId":-1,"statusName":"上架","displayName":"","takeAddress":"11111111","goodsImage":"/images/goods/20170726/498f6fd9-9707-4c47-8997-b8b7c5e225d940768.png","goodsPhone":"11111111","goodsContent":"1111111","hotFlag":1,"goodsSavo":0},{"id":17,"goodsName":"测试2","goodsNum":203,"goodsIntegral":10000,"imageUrl":"http://192.168.1.242:8889/static/upload/images/goods/20170724/fdb378f2-e68c-41bb-973c-74969b7fb19837679.png","isDisplay":-1,"status":1,"createTime":"2017-07-22 09:36:48","createUserId":32,"lastModifyTime":"2017-07-26 08:51:45","lastModifyUserId":-1,"statusName":"上架","displayName":"","takeAddress":"上海嘉定金园五路333","goodsImage":"/images/goods/20170724/3448b6c0-c07b-416d-9fa8-0ef9c8a724c824795.png","goodsPhone":"15564664651","goodsContent":"22222222222222222221321321321321211313","hotFlag":1,"goodsSavo":0},{"id":16,"goodsName":"测试1","goodsNum":177,"goodsIntegral":11,"imageUrl":"http://192.168.1.242:8889/static/upload/images/goods/20170724/623749da-39cd-42e1-a583-c845cef3f15141605.png","isDisplay":-1,"status":1,"createTime":"2017-07-13 09:11:12","createUserId":32,"lastModifyTime":"2017-07-26 17:28:36","lastModifyUserId":-1,"statusName":"上架","displayName":"","takeAddress":"上海嘉定1111111","goodsImage":"/images/goods/20170724/a59bf2e8-3cb1-40eb-ba89-064c4cf2663196785.png","goodsPhone":"11","goodsContent":"22222","hotFlag":1,"goodsSavo":0}]
         * count : 4
         */

        @SerializedName("count")
        public int count;
        @SerializedName("result")
        public List<ResultBean> result;

        public static class ResultBean {
            /**
             * id : 21
             * goodsName : eeee
             * goodsNum : 21213
             * goodsIntegral : 2222
             * imageUrl : http://192.168.1.242:8889/static/upload/images/goods/20170801/cdfa24e6-4d7d-4e92-9b75-e5eaa138719f93821.png
             * isDisplay : -1
             * status : 1
             * createTime : 2017-08-01 16:12:44
             * createUserId : 32
             * lastModifyTime : 2017-08-01 16:12:44
             * lastModifyUserId : 32
             * statusName : 上架
             * displayName :
             * takeAddress : 22223213
             * goodsImage : /images/goods/20170801/3c0325bd-e23d-4d44-9a42-41e1193c464335971.png
             * goodsPhone : 23213123
             * goodsContent : 23213232123232321321321321213213213213213213
             * hotFlag : 2
             * goodsSavo : 0
             */

            @SerializedName("id")
            public int id;
            @SerializedName("goodsName")
            public String goodsName;
            @SerializedName("goodsNum")
            public int goodsNum;
            @SerializedName("goodsIntegral")
            public int goodsIntegral;
            @SerializedName("imageUrl")
            public String imageUrl;
            @SerializedName("isDisplay")
            public int isDisplay;
            @SerializedName("status")
            public int status;
            @SerializedName("createTime")
            public String createTime;
            @SerializedName("createUserId")
            public int createUserId;
            @SerializedName("lastModifyTime")
            public String lastModifyTime;
            @SerializedName("lastModifyUserId")
            public int lastModifyUserId;
            @SerializedName("statusName")
            public String statusName;
            @SerializedName("displayName")
            public String displayName;
            @SerializedName("takeAddress")
            public String takeAddress;
            @SerializedName("goodsImage")
            public String goodsImage;
            @SerializedName("goodsPhone")
            public String goodsPhone;
            @SerializedName("goodsContent")
            public String goodsContent;
            @SerializedName("hotFlag")
            public int hotFlag;
            @SerializedName("goodsSavo")
            public int goodsSavo;
        }
    }
}
