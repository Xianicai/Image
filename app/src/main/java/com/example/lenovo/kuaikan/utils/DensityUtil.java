package com.example.lenovo.kuaikan.utils;

/**
 * Created by Zhanglibin on 2017/4/1.
 */

public class DensityUtil {

    /**
     * dp转px
     */
    public static int dp2px(float dpValue) {
        return (int) (dpValue * Mobile.DENSITY + 0.5f);
    }

    /**
     * px转dp
     */
    public static int px2dp(float pxValue) {
        return (int) (pxValue / Mobile.DENSITY + 0.5f);
    }

    /**
     * px转sp
     */
    public static int px2sp(float pxValue) {
        return (int) (pxValue / Mobile.SCALED_DENSITY + 0.5f);
    }

    /**
     * sp转px
     */
    public static int sp2px(float spValue) {
        return (int) (spValue * Mobile.SCALED_DENSITY + 0.5f);
    }

}
