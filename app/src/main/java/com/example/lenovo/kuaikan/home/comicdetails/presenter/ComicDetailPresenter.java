package com.example.lenovo.kuaikan.home.comicdetails.presenter;

import com.example.lenovo.kuaikan.base.basemvp.BasePresenter;
import com.example.lenovo.kuaikan.home.comicdetails.model.ComicDetailModel;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.home.comicdetails.view.ImpComicDatailView;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/16.
 */

public class ComicDetailPresenter extends BasePresenter<ImpComicDatailView> {
    ComicDetailModel mModel;

    public ComicDetailPresenter() {
        mModel = new ComicDetailModel();
    }
    public void getComicDetaiData(String comicId){
        getMvpView().showLoadingDialog();
        mModel.getComicsData(comicId,new Callback<ComicDetailBean>() {
            @Override
            public void execute(ComicDetailBean obj) {
                getMvpView().cancelLoadingDialog();
                if (obj != null) {
                    getMvpView().getComicsDataSuccess(obj);
                }
            }
        });
    }
}
