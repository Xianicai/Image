package com.example.lenovo.kuaikan.business.read.mvp.model;

import com.example.lenovo.kuaikan.business.read.data.BeanRead;
import com.example.lenovo.kuaikan.business.read.data.ReqRead;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class ReadModel implements IReadModel {
    @Override
    public void getSeverData(final GetDataListener listener) {
            final ReqRead req = new ReqRead();

            String url = Urls.parse(Urls.HOME_READ);
            NetAsynTask.connectByGet(url, null, req, new NetAsynTask.CallBack() {

                @Override
                public void onGetSucc() {
                    if (req.code == 200) {
                        //初始化一个bean用保存本次请求下来的数据
                        if (listener != null) {
                            listener.success(req.getT());
                        }

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


    public interface GetDataListener {
        void success(BeanRead beanRead);

        void fail();
    }
}
