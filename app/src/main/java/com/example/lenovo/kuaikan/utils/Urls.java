package com.example.lenovo.kuaikan.utils;

/**
 * Created by Zhanglibin on 2017/3/31.
 */

public class Urls {
    /**
     * 热门daily
     * */
    public static String HOME_HOT_SUNDAY = "http://api.kuaikanmanhua.com/v1/" +
            "daily/comic_lists/%1$s?since=%2$s&gender=1&sa_event=eyJkaXN0aW5jdF9pZCI6IkE6ZmNkMjA5NWNhNmYyM2JiNy" +
            "IsImV2ZW50IjoiUmVhZEhvbWVQYWdlIiwib3JpZ2luYWxfaWQiOiJBOmZjZDIwOTVjYTZmMjNiYjciLCJwcm9qZWN0Ijoia3" +
            "VhaWthbl9hcHAiLCJwcm9wZXJ0aWVzIjp7IkZpbmRUYWJOYW1lIjoi5o6o6I2QIiwiRnJvbUhvbWVwYWdlVGFiTmFtZSI6Iue" +
            "DremXqCIsIkZyb21Ib21lcGFnZVVwZGF0ZURhdGUiOjAsIkdlbmRlclR5cGUiOiLnlLfniYgiLCJIb21lcGFnZVRhYk5hbWU" +
            "iOiLng63pl6giLCJIb21lcGFnZVVwZGF0ZURhdGUiOjAsIlRyaWdnZXJQYWdlIjoiSG9tZVBhZ2UiLCJWQ29tbX" +
            "VuaXR5VGFiTmFtZSI6IueDremXqCIsIlByb3BlcnR5RXZlbnQiOiJSZWFkSG9tZVBhZ2UiLCJhYnRlc3RfZ3" +
            "JvdXAiOjEsIiRhcHBfdmVyc2lvbiI6IjMuOS4zIiwiJGxpYl92ZXJzaW9uIjoiMS42LjM0IiwiJG1hbnVmYWN0dXJl" +
            "ciI6Im51YmlhIiwiJG1vZGVsIjoiTlg1MzFKIiwiJG9zIjoiQW5kcm9pZCIsIiRvc192ZXJzaW9uIjoiNi4wLjEiLCIkc2" +
            "NyZWVuX2hlaWdodCI6MTkyMCwiJHNjcmVlbl93aWR0aCI6MTA4MCwiJHdpZmkiOnRydWUsIiRjYXJyaWVyIjoiQ0hOLV" +
            "VOSUNPTSIsIiRuZXR3b3JrX3R5cGUiOiJXSUZJIn0sInRpbWUiOjE0OTA5NDgxNTYyMTMsInR5cGUiOiJ0cmFjayJ9;";
    /**
     * 广场feeds
     * */
    public static String COMMUNITY_SQUARE_FEEDS = "http://api.kuaikanmanhua.com/v1/feeds/feed_lists?" +
            "uid=&since=0&page_num=%1$s&catalog_type=%2$s&sa_event=";
    public static String FEEDS = "eyJkaXN0aW5jdF9pZCI6IjM3MTMyMTM3IiwiZXZlbnQiOiJSZWFkVkNvbW11bml0eSIsIm9yaWdpbmF" +
            "sX2lkIjoiQTpmY2QyMDk1Y2E2ZjIzYmI3IiwicHJvamVjdCI6Imt1YWlrYW5fYXBwIiwicHJvcGVydGllcyI6eyJGaW5kVGFiTmFtZ" +
            "SI6IuaOqOiNkCIsIkZyb21WQ29tbXVuaXR5VGFiTmFtZSI6IueDremXqCIsIkhvbWVwYWdlVGFiTmFtZSI6IueDremXqCIsIkhvbW" +
            "VwYWdlVXBkYXRlRGF0ZSI6MCwiVHJpZ2dlclBhZ2UiOiJWQ29tbXVuaXR5UGFnZSIsIlZDb21tdW5pdHlUYWJOYW1lIjoi5pyA5p" +
            "awIiwiUHJvcGVydHlFdmVudCI6IlJlYWRWQ29tbXVuaXR5IiwiYWJ0ZXN0X2dyb3VwIjoxLCIkYXBwX3ZlcnNpb24iOiIzLjkuMy" +
            "IsIiRsaWJfdmVyc2lvbiI6IjEuNi4zNCIsIiRtYW51ZmFjdHVyZXIiOiJudWJpYSIsIiRtb2RlbCI6Ik5YNTMxSiIsIiRvcyI6Ik" +
            "FuZHJvaWQiLCIkb3NfdmVyc2lvbiI6IjYuMC4xIiwiJHNjcmVlbl9oZWlnaHQiOjE5MjAsIiRzY3JlZW5fd2lkdGgiOjEwODAsIi" +
            "R3aWZpIjp0cnVlLCIkY2FycmllciI6IkNITi1VTklDT00iLCIkbmV0d29ya190eXBlIjoiV0lGSSJ9LCJ0aW1lIjoxNDkxMTEwNTg" +
            "3MTI4LCJ0eXBlIjoidHJhY2sifQ%3D%3D";
    public static String parse(String url, Object... args) {
        return String.format(url, args);
    }
    public static String DISCOVER_CLASSIFY = "http://api.kuaikanmanhua.com/v1/topic_new/lists" +
                                            "/get_by_tag?tag=%1$s&since=%2$s&count=20&gender=1&sort=%3$s&sa_event=";
    public static String CLASSIFY = "eyJkaXN0aW5jdF9pZCI6IjM3MTMyM" +
            "TM3IiwiZXZlbnQiOiJSZWFkRmluZFBhZ2UiLCJvcmlnaW5hbF9pZCI6IkE6ZmNkMjA5NWNhNmYyM2JiNyIsInByb2plY3Qi" +
            "OiJrdWFpa2FuX2FwcCIsInByb3BlcnRpZXMiOnsiQ2F0ZWdvcnkiOiLlhajpg6giLCJGaW5kQ2F0ZWdvcnlUYWJOYW1lIj" +
            "oi5YWo6YOoIiwiRmluZFRhYk5hbWUiOiLliIbnsbsiLCJGcm9tRmluZENhdGVnb3J5VGFiTmFtZSI6IuWFqOmDqCIsIkZyb21GaW" +
            "5kVGFiTmFtZSI6IuaOqOiNkCIsIkdlbmRlclR5cGUiOiLnlLfniYgiLCJIb21lcGFnZVRhYk5hbWUiOiLng63pl6giLCJIb21lcGFn" +
            "ZVVwZGF0ZURhdGUiOjAsIklzQXV0b0xvYWQiOmZhbHNlLCJUcmlnZ2VyUGFnZSI6IlZDb21tdW5pdHlQYWdlIiwiVkNvbW11bml0e" +
            "VRhYk5hbWUiOiLlhbPms6giLCJQcm9wZXJ0eUV2ZW50IjoiUmVhZEZpbmRQYWdlIiwiYWJ0ZXN0X2dyb3VwIjoxLCIkYXBwX3ZlcnN" +
            "pb24iOiIzLjkuMyIsIiRsaWJfdmVyc2lvbiI6IjEuNi4zNCIsIiRtYW51ZmFjdHVyZXIiOiJudWJpYSIsIiRtb2RlbCI6Ik5YNTMxS" +
            "iIsIiRvcyI6IkFuZHJvaWQiLCIkb3NfdmVyc2lvbiI6IjYuMC4xIiwiJHNjcmVlbl9oZWlnaHQiOjE5MjAsIiRzY3JlZW5fd2lkdGg" +
            "iOjEwODAsIiR3aWZpIjp0cnVlLCIkY2FycmllciI6IkNITi1VTklDT00iLCIkbmV0d29ya190eXBlIjoiV0lGSSJ9LCJ0aW1lIjoxN" +
            "DkxMTEwNzMxOTczLCJ0eXBlIjoidHJhY2sifQ%3D%3D ";

    public static String DISCOVER_RECOMMEND="https://api.kkmh.com/v1/topic_new/discovery_list?action_type=9";
}
