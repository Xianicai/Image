package com.example.lenovo.kuaikan.utils.retrofit;

import android.app.Dialog;
import android.content.DialogInterface;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Zhanglibin on 2017/4/24.
 */

public class RxSchedulers {
    /**
     * 无进度Schedulers
     */
    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return new ObservableTransformer<T, T>() {
            @Override public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());

            }
        };
    }

    /**
     * 有进度Schedulers
     */
    public static <T> ObservableTransformer<T, T> applySchedulers(@NonNull final Dialog dialog) {
        return new ObservableTransformer<T, T>() {
            @Override public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream
                        .delay(1, TimeUnit.SECONDS)
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(@NonNull final Disposable disposable) throws Exception {
                                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                    @Override public void onCancel(DialogInterface dialog) {
                                        disposable.dispose();
                                    }
                                });
                                dialog.show();
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnTerminate(new Action() {
                            @Override public void run() throws Exception {
                                dialog.dismiss();
                            }
                        });
            }
        };
    }
}
