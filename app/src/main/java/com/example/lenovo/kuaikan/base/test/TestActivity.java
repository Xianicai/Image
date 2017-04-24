package com.example.lenovo.kuaikan.base.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.utils.retrofit.HttpResult;
import com.example.lenovo.kuaikan.utils.retrofit.HttpResultSubscriber;
import com.example.lenovo.kuaikan.utils.retrofit.RxSchedulers;
import com.example.lenovo.kuaikan.utils.retrofit.ServiceFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        ServiceFactory.getInstance()
                .createService(ComicService.class)
                .getComicDetialData("1055")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxSchedulers.<HttpResult<ComicDetailBean>>applySchedulers())
                .subscribe(new HttpResultSubscriber<ComicDetailBean>() {
                    @Override
                    public void Success(ComicDetailBean detailBean) {
                        Log.d("detailBean",detailBean.toString());
                    }

                    @Override
                    public void Error(Throwable e) {

                    }

                    @Override
                    public void Completed() {

                    }
                });


    }
}
