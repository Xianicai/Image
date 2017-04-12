package com.example.lenovo.kuaikan.business.read.mvp.model;

import com.example.lenovo.kuaikan.business.read.data.BeanComments;
import com.example.lenovo.kuaikan.business.read.data.BeanRead;
import com.example.lenovo.kuaikan.utils.Callback;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public interface IReadModel {
    void getSeverData( Callback<BeanRead> callback ,String comicsId);
    void getCommentData( Callback<BeanComments> callback,String comicsId);
}
