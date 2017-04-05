package com.example.lenovo.kuaikan.utils.netutil;


import android.support.annotation.NonNull;
import android.util.Log;

import org.xutils.common.Callback;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

/**
 * ZY:统一的网络请求封装
 * Created by zhanglibin on 2016/9/5.
 */
public class NetAsynTask {
    private static final String TAG = "NetAsynTask";
    private static int GET = 1;
    private static int POST = 2;

    /**
     * 网络获取数据的回调接口
     */
    public interface CallBack {
        /**
         * 获取成功
         */
        void onGetSucc();

        /**
         * 请求完成
         */
        void onGetFinished();

        /**
         * 获取成功，但是没有获取到想要得到的数据
         */
        void onGetFaild();

        /**
         * 获取失败，网络错误等其他原因
         */
        void onGetError();
    }

    /**
     * 网络上传下载文件的回调接口
     */
    public interface CallBackForFile {
        /**
         * 数据获取成功
         */
        void onGetSucc();

        /**
         * 网络请求完成
         */
        void onGetFinished();

        /**
         * 请求成功，但是没有获取到想要得到的数据
         */
        void onGetFaild();

        /**
         * 获取失败，网络错误等其他原因
         */
        void onGetError();

        /**
         * 网络等待状态
         */
        void onWaiting();

        /**
         * 网络开始请求
         */
        void onStarted();

        /**
         * 网络加载中
         */
        void onLoading();
    }

    /**
     * 网络请求Get方法
     */
    public static void connectByGet(String url, Map<String, String> map, ReqCommon req, CallBack call) {
        RequestParams params = getReqParamsForGet(url, map);
        Log.i("GET", params.toString());
        connetData(GET,call, params, req);
    }

    @NonNull
    private static RequestParams getReqParamsForGet(String url, Map<String, String> map) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }
        return params;
    }


    /**
     * 网络请求Post方法
     */
    public static void connectByPost(String url, Map<String, String> map, ReqCommon req, CallBack call) {
        RequestParams params = getReqParamsForPost(url, map);
        Log.i("POST", params.toString());
        connetData(POST,call, params, req);
    }

    @NonNull
    private static RequestParams getReqParamsForPost(String url, Map<String, String> map) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        return params;
    }

    private static void connetData(int Type ,final CallBack call, RequestParams params, final ReqCommon req) {
        if (Type == GET) {
            x.http().get(params, new CommonCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    if (s != null) {
                        Log.d(TAG, "onSuccess() called with: " + "s = [" + s + "]");
                        req.getNetData(s);
                    }
                    if (call != null) {
                        call.onGetSucc();
                    }

                }

                @Override
                public void onError(Throwable throwable, boolean b) {
                    Log.d(TAG, "onError() called with: " + "throwable = [" + throwable + "], b = [" + b + "]");
                    if (call != null) {
                        call.onGetError();
                    }
                }

                @Override
                public void onCancelled(CancelledException e) {
                    Log.d(TAG, "onCancelled() called with: " + "e = [" + e + "]");
                    if (call != null) {
                        call.onGetFaild();
                    }
                }

                @Override
                public void onFinished() {
                    Log.d(TAG, "onFinished() called with: " + "");
                    if (call != null) {
                        call.onGetFinished();
                    }
                }
            });
        }else if (Type == POST){
            x.http().post(params, new CommonCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    if (s != null) {
                        Log.d(TAG, "onSuccess() called with: " + "s = [" + s + "]");
                        req.getNetData(s);
                    }
                    if (call != null) {
                        call.onGetSucc();
                    }

                }

                @Override
                public void onError(Throwable throwable, boolean b) {
                    Log.d(TAG, "onError() called with: " + "throwable = [" + throwable + "], b = [" + b + "]");
                    if (call != null) {
                        call.onGetError();
                    }
                }

                @Override
                public void onCancelled(CancelledException e) {
                    Log.d(TAG, "onCancelled() called with: " + "e = [" + e + "]");
                    if (call != null) {
                        call.onGetFaild();
                    }
                }

                @Override
                public void onFinished() {
                    Log.d(TAG, "onFinished() called with: " + "");
                    if (call != null) {
                        call.onGetFinished();
                    }
                }
            });
        }

    }


    /**
     * 上传文件的方法
     */
    public static void UpLoadFile(String url, Map<String, String> map, CallBackForFile callBackForFile) {
        RequestParams params = getReqParamsForPost(url, map);
        params.setMultipart(true);
        connetLoadFile(params, callBackForFile);
    }

    /**
     * 下载文件的方法
     */
    public static void DownLoadFile(String url, String filepath, CallBackForFile callBackForFile) {
        RequestParams params = new RequestParams(url);
        //设置断点续传
        params.setAutoResume(true);
        //下载地址
        params.setSaveFilePath(filepath);

        connetLoadFile(params, callBackForFile);
    }

    private static void connetLoadFile(RequestParams params, final CallBackForFile call) {
        x.http().get(params, new Callback.ProgressCallback<String>() {
            @Override
            public void onSuccess(String s) {
                call.onGetSucc();
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                call.onGetError();
            }

            @Override
            public void onCancelled(CancelledException e) {
                call.onGetFaild();
            }

            @Override
            public void onFinished() {
                call.onGetFinished();
            }

            @Override
            public void onWaiting() {
                call.onWaiting();
            }

            @Override
            public void onStarted() {
                call.onStarted();
            }

            @Override
            public void onLoading(long l, long l1, boolean b) {
                call.onLoading();
            }
        });
    }


}
