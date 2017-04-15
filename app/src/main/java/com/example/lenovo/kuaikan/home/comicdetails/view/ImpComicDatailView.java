package com.example.lenovo.kuaikan.home.comicdetails.view;

import com.example.lenovo.kuaikan.base.basemvp.BaseView;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;

/**
 * Created by Zhanglibin on 2017/4/16.
 */

public interface ImpComicDatailView extends BaseView {
    void getComicsDataSuccess(ComicDetailBean detailBean);
}
