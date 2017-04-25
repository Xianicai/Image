package com.example.lenovo.kuaikan.base.test;

import java.util.List;

/**
 * Created by Zhanglibin on 2017/4/25.
 */

public class FBean {
    int code;
    String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TestBean> getTestBeen() {
        return mTestBeen;
    }

    public void setTestBeen(List<TestBean> testBeen) {
        mTestBeen = testBeen;
    }

    List<TestBean> mTestBeen;
}
