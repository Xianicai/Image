package com.example.lenovo.kuaikan.base.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.utils.retrofit.HttpResultSubscriber;
import com.example.lenovo.kuaikan.utils.retrofit.ServiceFactory;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
                .getComicDetialData("")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpResultSubscriber<ComicDetailBean>());


    }
}
