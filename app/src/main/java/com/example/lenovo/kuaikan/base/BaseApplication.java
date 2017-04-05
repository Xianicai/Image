package com.example.lenovo.kuaikan.base;

import android.app.Application;

import org.xutils.x;

/**
 * ZY:
 * Created by zhanglibin on 2016/9/2.
 */
public class BaseApplication extends Application {
    public static BaseApplication app;
    public static BaseApplication getInstance(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        // 初始化
        x.Ext.init(this);
        // 是否输出debug日志
        x.Ext.setDebug(true);
    }

}