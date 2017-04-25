package com.example.lenovo.kuaikan.base.test;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.kuaikan.R;
import com.example.lenovo.kuaikan.utils.retrofit.HttpResult;
import com.example.lenovo.kuaikan.utils.retrofit.HttpResultSubscriber;
import com.example.lenovo.kuaikan.utils.retrofit.RxSchedulers;
import com.example.lenovo.kuaikan.utils.retrofit.ServiceFactory;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.tv_con)
    TextView mTvCon;
    private LanguageSettingUtil languageSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        LanguageSettingUtil.init(this);// 初始化
        languageSetting = LanguageSettingUtil.get();// 检查是否已经初始化
    }


    private void getServerData() {
        ServiceFactory.getInstance()
                .createService(ComicService.class)
                .getComicDetialData("1055")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxSchedulers.<HttpResult<TestBean>>applySchedulers())
                .subscribe(new HttpResultSubscriber<TestBean>() {
                    @Override
                    public void Success(TestBean detailBean) {
                        Log.d("detailBean", detailBean.toString());
                    }

                    @Override
                    public void Error(Throwable e) {

                    }

                    @Override
                    public void Completed() {

                    }
                });
    }

    /**
     * 切换语言
     *
     * @param language
     */

    private void switchLanguage(String language) {

        //设置应用语言类型

        Resources resources = getResources();

        Configuration config = resources.getConfiguration();

        DisplayMetrics dm = resources.getDisplayMetrics();

        if (language.equals("zh_simple")) {

            config.locale = Locale.SIMPLIFIED_CHINESE;

        } else if (language.equals("en")) {

            config.locale = Locale.ENGLISH;

        } else {

            config.locale = Locale.getDefault();

        }

        resources.updateConfiguration(config, dm);

        //更新语言后，destroy当前页面，重新绘制

        finish();

        Intent it = new Intent(TestActivity.this, TestActivity.class);

        //清空任务栈确保当前打开activit为前台任务栈栈顶

        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(it);

    }

    @OnClick({R.id.btn, R.id.btn_zh, R.id.btn_en})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                getServerData();
                break;
            case R.id.btn_zh:
                switchLanguage("zh_simple");
                break;
            case R.id.btn_en:
                languageSetting.saveLanguage("en");// 设置为"en"语言
                LanguageSettingUtil.get().refreshLanguage();// 刷新
                mTvCon.setText(R.string.dream);
                break;
        }
    }
}
