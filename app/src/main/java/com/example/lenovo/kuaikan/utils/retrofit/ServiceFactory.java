package com.example.lenovo.kuaikan.utils.retrofit;

import com.example.lenovo.kuaikan.base.BaseApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zhanglibin on 2017/4/24.
 */

public class ServiceFactory {

    private final Retrofit mRetrofit;

    private ServiceFactory() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.kuaikanmanhua.com/v1/")
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static class SingletonHolder {
        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }

    public static ServiceFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * create a service
     *
     * @param serviceClass
     * @param <S>
     * @return
     */
    public <S> S createService(Class<S> serviceClass) {
//        String baseUrl = "";
//        try {
//            Field field1 = serviceClass.getField("BASE_URL");
//            baseUrl = (String) field1.get(serviceClass);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.getMessage();
//            e.printStackTrace();
//        }

        return mRetrofit.create(serviceClass);
    }

    private final static long DEFAULT_TIMEOUT = 10;

    private OkHttpClient getOkHttpClient() {
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        //设置超时时间
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        //设置缓存
        File httpCacheDirectory = new File(FileUtils.getCacheDir(BaseApplication.getInstance()), "OkHttpCache");
        httpClientBuilder.cache(new Cache(httpCacheDirectory, 10 * 1024 * 1024));
        httpClientBuilder.addInterceptor(new LoggerInterceptor());
        return httpClientBuilder.build();
    }
}
