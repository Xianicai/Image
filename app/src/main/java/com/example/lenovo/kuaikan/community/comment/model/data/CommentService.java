package com.example.lenovo.kuaikan.community.comment.model.data;

import com.example.lenovo.kuaikan.utils.retrofit.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Zhanglibin on 2017/4/25.
 */

public interface CommentService {
    @GET("http://api.kuaikanmanhua.com/v1/comments/feed/{feedId}/order/{type}?offset={firstId}&limit=20")
    Observable<HttpResult<CommentBean>> getCommentsData(@Path("feedId" ) String feedId,@Path("type")String type,@Query("firstId") String firstId);
}
