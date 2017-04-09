package com.example.lenovo.kuaikan.business.read.mvp.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.lenovo.kuaikan.base.basemvp.BasePresenter;
import com.example.lenovo.kuaikan.business.read.data.BeanRead;
import com.example.lenovo.kuaikan.business.read.mvp.model.IReadModel;
import com.example.lenovo.kuaikan.business.read.mvp.model.ReadModel;
import com.example.lenovo.kuaikan.business.read.mvp.view.IReadView;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class ReadPresenter extends BasePresenter<IReadView>{

    private IReadModel mModel;

    private Handler mHandler;

    public ReadPresenter() {
        mModel = new ReadModel();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void getSeverData() {
        mModel.getSeverData(new ReadModel.GetDataListener() {
            @Override
            public void success(final BeanRead beanRead) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        ((IReadView)getMvpView()).getServerDataSuccess(beanRead);
                    }
                });
            }

            @Override
            public void fail() {

            }
        });

//        Observable.just("")
//                .map(new Function<String, BeanRead>() {
//                    @Override
//                    public BeanRead apply(@NonNull String s) throws Exception {
//                        return mModel.getSeverData();
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<BeanRead>() {
//                    @Override
//                    public void accept(@NonNull BeanRead o) throws Exception {
//                        ((IReadView)getMvpView()).getServerDataSuccess(o);
//                    }
//                });

    }

    @Override
    public void detachView() {
        super.detachView();
        mHandler.removeCallbacksAndMessages(null);
    }
}
