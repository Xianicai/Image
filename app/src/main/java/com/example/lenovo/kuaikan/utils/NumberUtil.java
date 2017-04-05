package com.example.lenovo.kuaikan.utils;

/**
 * Created by Zhanglibin on 2017/4/2.
 * 该工具类 如果数字大于10000则转化以"万"为单位   如果数字大于100000000则转化以"亿"为单位
 */

public class NumberUtil {
    //    转化为以万为单位
    public static String buildTenThousand(int number) {
        int n;
        if (number >= 10000) {
            n =  number / 10000;
            return n + "万";
        } else {
            n = number;
        }
        return n+"";
    }
    //    转化为以亿为单位
    public static String buildHundredMillion(long number) {
        float n;
        if (number >= 100000000) {
            n =number / 100000000;
            return n + "亿";

        } else {
            n = number;
        }
        return n + "";
    }

}
