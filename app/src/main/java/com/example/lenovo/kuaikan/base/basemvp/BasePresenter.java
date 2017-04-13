package com.example.lenovo.kuaikan.base.basemvp;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class BasePresenter<T extends BaseView> {

    private T view;

    public void attachView(BaseView view){
        this.view = (T) view;
    }

    public T getMvpView(){
        return view;
    }

    public void detachView(){
        if (view!=null){
            view = null;
        }
    }

}
