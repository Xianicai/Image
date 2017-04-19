package com.example.lenovo.kuaikan.home.comicread.view;

import com.example.lenovo.kuaikan.base.basemvp.BaseView;
import com.example.lenovo.kuaikan.home.comicread.model.data.BeanComments;

/**
 * Created by Zhanglibin on 2017/4/19.
 */

public interface CommentView extends BaseView {
    void getCommentDataSuccss(BeanComments beanComments);
}
