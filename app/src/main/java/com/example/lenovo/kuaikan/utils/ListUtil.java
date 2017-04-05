package com.example.lenovo.kuaikan.utils;

import java.util.List;

/**
 * list的工具类，主要增加了一些为空的判断
 * @author RenTao
 * @time Jul 5, 2015 11:36:27 AM
 */
public class ListUtil {

    private ListUtil() {}

    /**
     * 获取list的size
     * @param list
     * @return list为null的话，会返回0；其他返回list.size()
     */
    public static int getSize(List<?> list) {
        return list == null ? 0 : list.size();
    }

    /**
     * list是否为空
     * @param list
     * @return true：list为null或者list.size() == 0；否则为false
     */
    public static boolean isEmpty(List<?> list) {
        return (list == null || list.size() == 0);
    }

    /**
     * list是否不为空
     * @param list
     * @return false：list为null或者list.size() == 0；否则为true
     */
    public static boolean isNotEmpty(List<?> list) {
        return list != null && list.size() > 0;
    }
    
    /**
     * 往list中增加added，假如list或者added为null，则什么都不会执行
     */
    public static <T> void add(List<T> source, T added) {
    	if (source != null && added != null) {
    		source.add(added);
    	}
    }
    
    /**
     * @see List#addAll(int, java.util.Collection)
     * 假如location < 0或者source为null或者added为null，则什么都不会执行
     */
    public static <T> void add(List<T> source, int location, T added) {
    	if (location >= 0 && source != null && added != null) {
    		source.add(location, added);
    	}
    }

    /**
     * 往list中增加一个list集合（added），假如list或者added为null，则什么都不会执行
     */
    public static <T> void addAll(List<T> source, List<T> added) {
        if (source != null && isNotEmpty(added)) {
            source.addAll(added);
        }
    }

    /**
     * 根据index获取list中的元素
     * @param list
     * @param index
     * @return 假如index < 0或者list为null或者index > list.size()，会直接返回null
     */
    public static <T> T get(List<T> list, int index) {
        if (index >= 0 && isNotEmpty(list) && index < list.size()) {
            return list.get(index);
        }
        return null;
    }

}
