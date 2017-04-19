package com.example.lenovo.kuaikan.home.comicdetails.presenter;

import com.example.lenovo.kuaikan.base.basemvp.BasePresenterImpl;
import com.example.lenovo.kuaikan.home.comicdetails.model.ComicDetailModel;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.home.comicdetails.view.ImpComicDatailView;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/16.
 */

public class ComicDetailPresenter extends BasePresenterImpl<ImpComicDatailView> {
    ComicDetailModel mModel;

    public ComicDetailPresenter() {
        mModel = new ComicDetailModel();
    }
    public void getComicDetaiData(String comicId){
        getView().showLoadingDialog();
        mModel.getComicsData(comicId,new Callback<ComicDetailBean>() {
            @Override
            public void execute(ComicDetailBean obj) {
                getView().cancelLoadingDialog();
                if (obj != null) {
                    getView().getComicsDataSuccess(obj);
                }
            }
        });
    }
}
