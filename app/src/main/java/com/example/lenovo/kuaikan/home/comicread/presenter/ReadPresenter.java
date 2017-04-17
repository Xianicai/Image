package com.example.lenovo.kuaikan.home.comicread.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.lenovo.kuaikan.base.basemvp.BasePresenter;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanComments;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanRead;
import com.example.lenovo.kuaikan.home.comicread.model.IReadModel;
import com.example.lenovo.kuaikan.home.comicread.model.ReadModel;
import com.example.lenovo.kuaikan.home.comicread.view.IReadView;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class ReadPresenter extends BasePresenter<IReadView> {

    private IReadModel mModel;

    private Handler mHandler;

    public ReadPresenter() {
        mModel = new ReadModel();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void getSeverData(String comicsId) {
        mModel.getSeverData(new Callback<BeanRead>() {
            @Override
            public void execute(BeanRead beanRead) {
                if (beanRead != null) {
                    ((IReadView) getMvpView()).getServerDataSuccess(beanRead);
                }
            }
        },comicsId);

        mModel.getCommentData(new Callback<BeanComments>() {
            @Override
            public void execute(BeanComments beanComments) {
                if (beanComments != null) {
                    ((IReadView) getMvpView()).getCommentDataSuccss(beanComments);
                }
            }
        },comicsId);

    }

    @Override
    public void detachView() {
        super.detachView();
        mHandler.removeCallbacksAndMessages(null);
    }
}
