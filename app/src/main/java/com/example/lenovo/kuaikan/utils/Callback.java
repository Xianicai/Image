package com.example.lenovo.kuaikan.utils;

/**
 * 通用的一个回调方法，抽取出来方便使用
 * @author RenTao
 * @time Mar 13, 2015 5:39:00 PM
 */
public interface Callback<T> {

	void execute(T obj);
	
}
