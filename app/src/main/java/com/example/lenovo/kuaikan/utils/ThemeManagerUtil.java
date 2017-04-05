package com.example.lenovo.kuaikan.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by Zhanglibin on 2017/3/28.
 */

public class ThemeManagerUtil {
    public static void smartTintManager(Activity context, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = context.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 创建状态栏的管理实例

            SystemBarTintManager tintManager = new SystemBarTintManager(context);

            tintManager.setStatusBarTintEnabled(true);// 激活状态栏

            tintManager.setNavigationBarTintEnabled(true);//激活导航栏

            tintManager.setStatusBarTintResource(color);//给状态栏设置资源

            tintManager.setNavigationBarTintResource(color);//给导航栏设置资源
        }
    }
}
