package com.example.lenovo.kuaikan.business.read.mvp.model;

import com.example.lenovo.kuaikan.business.read.data.BeanRead;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public interface IReadModel {

//    void getSeverData();
    void getSeverData( Callback<BeanRead> callback);
}
