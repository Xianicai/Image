package com.example.lenovo.kuaikan.home.comicdetails.model;

import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/16.
 */

public interface ImpComicDetailModel {
    void getComicsData(Callback<ComicDetailBean> callback);
}
