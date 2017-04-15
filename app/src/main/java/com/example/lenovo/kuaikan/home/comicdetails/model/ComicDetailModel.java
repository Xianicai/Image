package com.example.lenovo.kuaikan.home.comicdetails.model;

import com.example.lenovo.kuaikan.home.comicdetails.model.data.ComicDetailBean;
import com.example.lenovo.kuaikan.home.comicdetails.model.data.ReqComicDetail;
import com.example.lenovo.kuaikan.utils.Callback;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;

/**
 * Created by Zhanglibin on 2017/4/15.
 */

public class ComicDetailModel implements ImpComicDetailModel {
    @Override
    public void getComicsData(final Callback<ComicDetailBean> callback) {
            final ReqComicDetail req = new ReqComicDetail();
            String url = Urls.parse(Urls.COMIC_DETAIL);
            NetAsynTask.connectByGet(url, null, req, new NetAsynTask.CallBack() {
                @Override
                public void onGetSucc() {
                    if (req.code == 200) {
                        ComicDetailBean comicDetailBean = req.getT();
                        callback.execute(comicDetailBean);
                    }
                }

                @Override
                public void onGetFinished() {
                }

                @Override
                public void onGetFaild() {

                }

                @Override
                public void onGetError() {

                }
            });
    }
}
