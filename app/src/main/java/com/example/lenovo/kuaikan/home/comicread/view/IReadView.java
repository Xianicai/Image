package com.example.lenovo.kuaikan.home.comicread.view;

import com.example.lenovo.kuaikan.base.basemvp.BaseView;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanComments;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanRead;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public interface IReadView extends BaseView{

    void getServerDataSuccess(BeanRead data);
    void getCommentDataSuccss(BeanComments beanComments);
    void getServerDataFail();

}
