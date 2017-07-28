package com.lanxiang.cheyaoyao.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Desc :活动列表数据
 * Created by WangDong on 2017/7/27.
 */

public class ActivityListData {

    /**
     * status : 1
     * message : 获取数据成功
     * data : {"totalSize":14,"items":[{"ca_id":53,"activityTitle":"投票:测试13","circleType":2,"imagUrl":"http://192.168.1.242:8889/static/upload/images/appvote/20170726/b0437067-06b1-4cc8-b8e4-4d06cf9f386056890.png","stateFlag":1},{"ca_id":52,"activityTitle":"投票:测试12","circleType":2,"imagUrl":"http://192.168.1.242:8889/static/upload/images/appvote/20170726/0383467f-8634-40d6-b4cf-dc64dc03a18e95552.png","stateFlag":3},{"ca_id":51,"activityTitle":"活动:测试11","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/4458ed5b-7097-4219-83db-48ef4b1eabdd69497.png","stateFlag":4},{"ca_id":50,"activityTitle":"活动:测试10","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/68853595-a631-42a3-944c-5762dbb356ab46760.png","stateFlag":1},{"ca_id":49,"activityTitle":"投票:投票6","circleType":2,"imagUrl":"http://192.168.1.242:8889/static/upload/images/appvote/20170726/b49a42fb-36bb-4e1f-ab7a-0739ed4c0ed119092.png","stateFlag":3},{"ca_id":48,"activityTitle":"投票:投票5","circleType":2,"imagUrl":"http://192.168.1.242:8889/static/upload/images/appvote/20170726/04da1f42-223c-469f-bfbe-02d9715e993f99246.png","stateFlag":1},{"ca_id":47,"activityTitle":"活动:活动8","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/2559a521-6313-470b-a9b0-56ba6f67b16f34735.png","stateFlag":1},{"ca_id":46,"activityTitle":"活动:活动7","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/f5cf3edb-7134-47cc-b3a2-84c7c35d69f768373.png","stateFlag":1},{"ca_id":45,"activityTitle":"活动:测试6","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/84646c08-0aed-4e1a-8232-328df198480d59292.png","stateFlag":1},{"ca_id":44,"activityTitle":"活动:活动测试5","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/609ea02f-9b73-4e1a-a5ba-1a2ebb4a76c501653.png","stateFlag":4}],"pageSize":10,"startPageIndex":0,"beforePageIndex":1,"currentPageIndex":1,"nextPageIndex":2,"lastPageIndex":0,"success":false,"conditions":[],"condition":"","paramsMap":{},"orderBy":"desc","totalPages":2,"isHasNext":true,"isHasPre":false,"currentPageRecordStart":0,"sort":"","maxPageIndexNumber":5,"pages":[1,2]}
     * token :
     */

    @SerializedName("status")
    public int status;
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public DataBean data;
    @SerializedName("token")
    public String token;

    public static class DataBean {
        /**
         * totalSize : 14
         * items : [{"ca_id":53,"activityTitle":"投票:测试13","circleType":2,"imagUrl":"http://192.168.1.242:8889/static/upload/images/appvote/20170726/b0437067-06b1-4cc8-b8e4-4d06cf9f386056890.png","stateFlag":1},{"ca_id":52,"activityTitle":"投票:测试12","circleType":2,"imagUrl":"http://192.168.1.242:8889/static/upload/images/appvote/20170726/0383467f-8634-40d6-b4cf-dc64dc03a18e95552.png","stateFlag":3},{"ca_id":51,"activityTitle":"活动:测试11","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/4458ed5b-7097-4219-83db-48ef4b1eabdd69497.png","stateFlag":4},{"ca_id":50,"activityTitle":"活动:测试10","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/68853595-a631-42a3-944c-5762dbb356ab46760.png","stateFlag":1},{"ca_id":49,"activityTitle":"投票:投票6","circleType":2,"imagUrl":"http://192.168.1.242:8889/static/upload/images/appvote/20170726/b49a42fb-36bb-4e1f-ab7a-0739ed4c0ed119092.png","stateFlag":3},{"ca_id":48,"activityTitle":"投票:投票5","circleType":2,"imagUrl":"http://192.168.1.242:8889/static/upload/images/appvote/20170726/04da1f42-223c-469f-bfbe-02d9715e993f99246.png","stateFlag":1},{"ca_id":47,"activityTitle":"活动:活动8","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/2559a521-6313-470b-a9b0-56ba6f67b16f34735.png","stateFlag":1},{"ca_id":46,"activityTitle":"活动:活动7","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/f5cf3edb-7134-47cc-b3a2-84c7c35d69f768373.png","stateFlag":1},{"ca_id":45,"activityTitle":"活动:测试6","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/84646c08-0aed-4e1a-8232-328df198480d59292.png","stateFlag":1},{"ca_id":44,"activityTitle":"活动:活动测试5","circleType":1,"imagUrl":"http://192.168.1.242:8889/static/upload/images/comactivity/20170726/609ea02f-9b73-4e1a-a5ba-1a2ebb4a76c501653.png","stateFlag":4}]
         * pageSize : 10
         * startPageIndex : 0
         * beforePageIndex : 1
         * currentPageIndex : 1
         * nextPageIndex : 2
         * lastPageIndex : 0
         * success : false
         * conditions : []
         * condition :
         * paramsMap : {}
         * orderBy : desc
         * totalPages : 2
         * isHasNext : true
         * isHasPre : false
         * currentPageRecordStart : 0
         * sort :
         * maxPageIndexNumber : 5
         * pages : [1,2]
         */

        @SerializedName("totalSize")
        public int totalSize;
        @SerializedName("pageSize")
        public int pageSize;
        @SerializedName("startPageIndex")
        public int startPageIndex;
        @SerializedName("beforePageIndex")
        public int beforePageIndex;
        @SerializedName("currentPageIndex")
        public int currentPageIndex;
        @SerializedName("nextPageIndex")
        public int nextPageIndex;
        @SerializedName("lastPageIndex")
        public int lastPageIndex;
        @SerializedName("success")
        public boolean success;
        @SerializedName("condition")
        public String condition;
        @SerializedName("paramsMap")
        public ParamsMapBean paramsMap;
        @SerializedName("orderBy")
        public String orderBy;
        @SerializedName("totalPages")
        public int totalPages;
        @SerializedName("isHasNext")
        public boolean isHasNext;
        @SerializedName("isHasPre")
        public boolean isHasPre;
        @SerializedName("currentPageRecordStart")
        public int currentPageRecordStart;
        @SerializedName("sort")
        public String sort;
        @SerializedName("maxPageIndexNumber")
        public int maxPageIndexNumber;
        @SerializedName("items")
        public List<ItemsBean> items;
        @SerializedName("conditions")
        public List<?> conditions;
        @SerializedName("pages")
        public List<Integer> pages;

        public static class ParamsMapBean {
        }

        public static class ItemsBean {
            /**
             * ca_id : 53
             * activityTitle : 投票:测试13
             * circleType : 2
             * imagUrl : http://192.168.1.242:8889/static/upload/images/appvote/20170726/b0437067-06b1-4cc8-b8e4-4d06cf9f386056890.png
             * stateFlag : 1
             */

            @SerializedName("ca_id")
            public int caId;
            @SerializedName("activityTitle")
            public String activityTitle;
            @SerializedName("circleType")
            public int circleType;
            @SerializedName("imagUrl")
            public String imagUrl;
            @SerializedName("stateFlag")
            public int stateFlag;
        }
    }
}
