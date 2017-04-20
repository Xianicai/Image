package com.example.lenovo.kuaikan.home.comicread.presenter;

import com.example.lenovo.kuaikan.base.basemvp.BasePresenterImpl;
import com.example.lenovo.kuaikan.home.comicread.model.IReadModel;
import com.example.lenovo.kuaikan.home.comicread.model.ReadModel;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanComments;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanRead;
import com.example.lenovo.kuaikan.home.comicread.view.IReadView;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class ReadPresenterImpl extends BasePresenterImpl<IReadView> implements ReadPresenter {

    private IReadModel mModel;

    public ReadPresenterImpl() {
        mModel = new ReadModel();
    }

    @Override
    public void getSeverData(String comicsId) {
        mModel.getSeverData(new Callback<BeanRead>() {
            @Override
            public void execute(BeanRead beanRead) {
                if (beanRead != null) {
                    getView().getServerDataSuccess(beanRead);
                }
            }
        }, comicsId);
    }

    @Override
    public void getCommentData(String comicsId) {
        mModel.getCommentData(new Callback<BeanComments>() {
            @Override
            public void execute(BeanComments beanComments) {
                if (beanComments != null) {

                }
            }
        }, comicsId);
    }
}
