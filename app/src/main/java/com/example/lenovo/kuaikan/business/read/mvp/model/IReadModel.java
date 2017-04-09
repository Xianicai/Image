package com.example.lenovo.kuaikan.business.read.mvp.model;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public interface IReadModel {

    void getSeverData(ReadModel.GetDataListener listener);
//    BeanRead getSeverData();
}
