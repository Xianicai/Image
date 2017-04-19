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

public class ReadPresenter extends BasePresenterImpl<IReadView> {

    private IReadModel mModel;

    public ReadPresenter() {
        mModel = new ReadModel();
    }

    public void getSeverData(String comicsId) {
        mModel.getSeverData(new Callback<BeanRead>() {
            @Override
            public void execute(BeanRead beanRead) {
                if (beanRead != null) {
                    getView().getServerDataSuccess(beanRead);
                }
            }
        },comicsId);

        mModel.getCommentData(new Callback<BeanComments>() {
            @Override
            public void execute(BeanComments beanComments) {
                if (beanComments != null) {
                     getView().getCommentDataSuccss(beanComments);
                }
            }
        },comicsId);

    }
}
