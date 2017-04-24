package com.example.lenovo.kuaikan.utils.retrofit;

/**
 * Created by Zhanglibin on 2017/4/24.
 */

public class HttpResult<T> {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    int code;
    String message;
    T data;
}
