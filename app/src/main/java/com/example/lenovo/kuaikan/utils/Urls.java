package com.example.lenovo.kuaikan.utils;

/**
 * Created by Zhanglibin on 2017/3/31.
 */

public class Urls {
    /**
     * 热门daily
     */
    public static String HOME_HOT_SUNDAY = "http://api.kuaikanmanhua.com/v1/" +
            "daily/comic_lists/%1$s?since=%2$s&gender=1";
    /**
     * 广场feeds
     */
    public static String COMMUNITY_SQUARE_FEEDS = "http://api.kuaikanmanhua.com/v1/feeds/feed_lists?" +
            "uid=&since=0&page_num=%1$s&catalog_type=%2$s";


    public static String DISCOVER_CLASSIFY = "http://api.kuaikanmanhua.com/v1/topic_new/lists" +
            "/get_by_tag?tag=%1$s&since=%2$s&count=20&gender=1&sort=%3$s";


    public static String DISCOVER_RECOMMEND = "https://api.kkmh.com/v1/topic_new/discovery_list?action_type=9";
    /**
     * 漫画详情（看漫画）
     */
    public static String HOME_READ = "http://api.kuaikanmanhua.com/v2/comic/%1$s";
    /**
     * 点赞（漫画）
     */
    public static String COMICSID_LIKE = "http://api.kuaikanmanhua.com/v1/comics/%1$s/like";
    public static String parse(String url, Object... args) {
        return String.format(url, args);
    }

}
