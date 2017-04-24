package com.example.lenovo.kuaikan.base.test;

import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.utils.retrofit.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Zhanglibin on 2017/4/24.
 */

public interface ComicService {
    String BASE_URL ="http://api.kuaikanmanhua.com/v1/";
    @GET("topics/{comicId}?sort=0")
    Observable<HttpResult<ComicDetailBean>> getComicDetialData(@Path("comicId") String comicId);

}
