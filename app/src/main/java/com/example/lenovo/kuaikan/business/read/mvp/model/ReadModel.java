package com.example.lenovo.kuaikan.business.read.mvp.model;

import com.example.lenovo.kuaikan.business.read.data.BeanRead;
import com.example.lenovo.kuaikan.business.read.data.ReqRead;
import com.example.lenovo.kuaikan.utils.Callback;
import com.example.lenovo.kuaikan.utils.Urls;
import com.example.lenovo.kuaikan.utils.netutil.NetAsynTask;

/**
 * Created by Zhanglibin on 2017/4/8.
 */

public class ReadModel implements IReadModel {
    private BeanRead mBeanRead;



    @Override
    public void getSeverData(final Callback<BeanRead> callback ,String comicsId) {
        final ReqRead req = new ReqRead();

        String url = Urls.parse(Urls.HOME_READ,comicsId);
        NetAsynTask.connectByGet(url, null, req, new NetAsynTask.CallBack() {

            @Override
            public void onGetSucc() {
                if (req.code == 200) {
                    //初始化一个bean用保存本次请求下来的数据
                    mBeanRead = req.getT();
                    callback.execute(mBeanRead);
//                    打印线程
//                    Log.e("TAG",Thread.currentThread().getName());

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
