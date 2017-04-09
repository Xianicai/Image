package com.example.lenovo.kuaikan.business.read.mvp.view;

import com.example.lenovo.kuaikan.base.basemvp.BaseView;
import com.example.lenovo.kuaikan.business.read.data.BeanRead;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public interface IReadView extends BaseView{

    void getServerDataSuccess(BeanRead data);

    void getServerDataFail();

}
