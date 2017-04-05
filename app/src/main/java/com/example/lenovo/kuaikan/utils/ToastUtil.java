package com.example.lenovo.kuaikan.utils;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.lenovo.kuaikan.base.BaseApplication;

/**
 * ZY:统一的Toast类
 * Created by zhanglibin on 2016/9/8.
 */
public class ToastUtil {
    private static Handler handler = new Handler(Looper.getMainLooper());

    private static Toast toast = null;

    private static Object synObj = new Object();

    public static void showMessage(final String msg) {
        showMessage(msg, Toast.LENGTH_SHORT);
    }

    public static void showMessage(final int msg) {
        showMessage(msg, Toast.LENGTH_SHORT);
    }

    public static void showMessage(final CharSequence msg, final int len) {
        if (msg == null || msg.equals("")) {
            return;
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                synchronized (synObj) { //加上同步是为了每个toast只要有机会显示出来
                    if (toast != null) {
                        toast.setText(msg);
                        toast.setDuration(len);
                    } else {
                        toast = Toast.makeText(BaseApplication.app.getApplicationContext(), msg, len);
                    }
                    toast.show();
                }
            }
        });
    }

    public static void showMessage(final int msg, final int len) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                synchronized (synObj) {
                    if (toast != null) {
                        //toast.cancel();
                        toast.setText(msg);
                        toast.setDuration(len);
                    } else {
                        toast = Toast.makeText(BaseApplication.app.getApplicationContext(), msg, len);
                    }
                    toast.show();
                }
            }
        });
    }

    public static void cancel(){
        if (toast != null) {
            toast.cancel();
        }
    }
}

