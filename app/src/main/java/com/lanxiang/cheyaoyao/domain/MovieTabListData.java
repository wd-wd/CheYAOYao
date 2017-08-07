package com.lanxiang.cheyaoyao.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Desc :视频数据
 * Created by WangDong on 2017/8/4.
 */

public class MovieTabListData {

    /**
     * menus : [{"name":"精华","submenus":[{"display_num":1,"name":"推荐","god_topic_type":"nan","url":"http://c.api.budejie.com/topic/list/jingxuan/1/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":2,"name":"视频","god_topic_type":"nan","url":"http://c.api.budejie.com/topic/list/jingxuan/41/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":"http://d.api.budejie.com/topic/list/chuanyue/41/"},{"display_num":1,"name":"图片","god_topic_type":"nan","url":"http://c.api.budejie.com/topic/list/jingxuan/10/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":"http://d.api.budejie.com/topic/list/chuanyue/10/"},{"display_num":1,"name":"段子","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/64/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":"http://d.api.budejie.com/topic/list/chuanyue/29/"},{"display_num":1,"name":"排行","god_topic_type":"nan","url":"http://s.budejie.com/topic/list/remen/1/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"互动区","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/44289/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"王者荣耀","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/15341/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":2,"name":"网红","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/3096/hot/","display_level":5,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"社会","god_topic_type":null,"url":"http://s.budejie.com/topic/tag-topic/473/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"自拍交友","god_topic_type":"nan","url":"http://s.budejie.com/topic/forum/9/1/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"影视分享","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/407/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"游戏","god_topic_type":null,"url":"http://s.budejie.com/topic/tag-topic/164/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":2,"name":"性感","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/54779/hot/","display_level":5,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"爆笑GIF","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/17083/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""}]},{"name":"新帖","submenus":[{"display_num":1,"name":"全部","god_topic_type":"nan","url":"http://c.api.budejie.com/topic/list/zuixin/1/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":"http://d.api.budejie.com/topic-recsys/audit-topic/1/"},{"display_num":2,"name":"视频","god_topic_type":"nan","url":"http://c.api.budejie.com/topic/list/zuixin/41/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":"http://d.api.budejie.com/topic-recsys/audit-topic/41/"},{"display_num":1,"name":"图片","god_topic_type":"nan","url":"http://c.api.budejie.com/topic/list/zuixin/10/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":"http://d.api.budejie.com/topic-recsys/audit-topic/10/"},{"display_num":1,"name":"段子","god_topic_type":"nan","url":"http://c.api.budejie.com/topic/list/zuixin/29/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":"http://d.api.budejie.com/topic-recsys/audit-topic/29/"},{"display_num":1,"name":"互动区","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/44289/new/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"王者荣耀","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/15341/new/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":2,"name":"网红","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/3096/new/","display_level":5,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":2,"name":"自拍交友","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/9/new/","display_level":0,"entrytype":null,"type":"topic","recsys_url":""},{"display_num":1,"name":"社会","god_topic_type":null,"url":"http://s.budejie.com/topic/tag-topic/473/new/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"爆笑GIF","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/17083/new/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":2,"name":"性感","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/54779/new/","display_level":5,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"影视分享","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/407/new/","display_level":0,"entrytype":null,"type":"topic","recsys_url":""},{"display_num":1,"name":"游戏","god_topic_type":null,"url":"http://s.budejie.com/topic/tag-topic/164/new/","display_level":0,"entrytype":"","type":"topic","recsys_url":""},{"display_num":1,"name":"声音","god_topic_type":"nan","url":"http://s.budejie.com/topic/list/zuixin/31/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""}]}]
     * default_menu : {"offline_day_3":"0_0","initial":"0_0","offline_day_7":"0_0"}
     */

    @SerializedName("default_menu")
    public DefaultMenuBean defaultMenu;
    @SerializedName("menus")
    public List<MenusBean> menus;

    public static class DefaultMenuBean {
        /**
         * offline_day_3 : 0_0
         * initial : 0_0
         * offline_day_7 : 0_0
         */

        @SerializedName("offline_day_3")
        public String offlineDay3;
        @SerializedName("initial")
        public String initial;
        @SerializedName("offline_day_7")
        public String offlineDay7;
    }

    public static class MenusBean {
        /**
         * name : 精华
         * submenus : [{"display_num":1,"name":"推荐","god_topic_type":"nan","url":"http://c.api.budejie.com/topic/list/jingxuan/1/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":2,"name":"视频","god_topic_type":"nan","url":"http://c.api.budejie.com/topic/list/jingxuan/41/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":"http://d.api.budejie.com/topic/list/chuanyue/41/"},{"display_num":1,"name":"图片","god_topic_type":"nan","url":"http://c.api.budejie.com/topic/list/jingxuan/10/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":"http://d.api.budejie.com/topic/list/chuanyue/10/"},{"display_num":1,"name":"段子","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/64/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":"http://d.api.budejie.com/topic/list/chuanyue/29/"},{"display_num":1,"name":"排行","god_topic_type":"nan","url":"http://s.budejie.com/topic/list/remen/1/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"互动区","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/44289/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"王者荣耀","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/15341/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":2,"name":"网红","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/3096/hot/","display_level":5,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"社会","god_topic_type":null,"url":"http://s.budejie.com/topic/tag-topic/473/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"自拍交友","god_topic_type":"nan","url":"http://s.budejie.com/topic/forum/9/1/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"影视分享","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/407/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"游戏","god_topic_type":null,"url":"http://s.budejie.com/topic/tag-topic/164/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":2,"name":"性感","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/54779/hot/","display_level":5,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""},{"display_num":1,"name":"爆笑GIF","god_topic_type":"nan","url":"http://s.budejie.com/topic/tag-topic/17083/hot/","display_level":0,"entrytype":"self.koushu.android.feed.16081610415837","type":"topic","recsys_url":""}]
         */

        @SerializedName("name")
        public String name;
        @SerializedName("submenus")
        public List<SubmenusBean> submenus;

        public static class SubmenusBean {
            /**
             * display_num : 1
             * name : 推荐
             * god_topic_type : nan
             * url : http://c.api.budejie.com/topic/list/jingxuan/1/
             * display_level : 0
             * entrytype : self.koushu.android.feed.16081610415837
             * type : topic
             * recsys_url :
             */

            @SerializedName("display_num")
            public int displayNum;
            @SerializedName("name")
            public String name;
            @SerializedName("god_topic_type")
            public String godTopicType;
            @SerializedName("url")
            public String url;
            @SerializedName("display_level")
            public int displayLevel;
            @SerializedName("entrytype")
            public String entrytype;
            @SerializedName("type")
            public String type;
            @SerializedName("recsys_url")
            public String recsysUrl;
        }
    }
}
