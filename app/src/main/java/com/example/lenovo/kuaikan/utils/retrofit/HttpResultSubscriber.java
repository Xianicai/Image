package com.example.lenovo.kuaikan.utils.retrofit;

import android.util.Log;

import com.example.lenovo.kuaikan.utils.ToastUtil;

import org.xutils.ex.HttpException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Zhanglibin on 2017/4/24.
 */

public abstract class HttpResultSubscriber<T> implements Observer<HttpResult<T>> {
    private static final String TAG = "Retrofit";


    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull HttpResult<T> tHttpResult) {
        if (tHttpResult.getCode() == 200) {
            Log.d(TAG, "onSuccess() called with: " + "s = [" + tHttpResult + "]");
            Success(tHttpResult.getData());
        } else {
            Error(new Throwable("error=" + tHttpResult.getCode()));
            ToastUtil.showMessage(tHttpResult.getMessage());
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        e.printStackTrace();
        if (e instanceof HttpException) {
            Log.d(TAG, "onError() called with: " + "throwable = [" + e + "], b = [" + e.getMessage() + "]");
        }
        Error(e);
    }

    @Override
    public void onComplete() {
        Completed();
    }

    public abstract void Success(T t);

    public abstract void Error(Throwable e);

    public abstract void Completed();
}
