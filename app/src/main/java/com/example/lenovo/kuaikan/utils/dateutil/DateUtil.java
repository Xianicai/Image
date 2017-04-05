package com.example.lenovo.kuaikan.utils.dateutil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Zhanglibin on 2017/4/1.
 */

public class DateUtil {
    /**
     * 将日期字符串转化为另一日期字符串。失败返回null。
     * @param date 旧日期字符串
     * @return 新日期字符串
     */
    public static String formatLongToDates(long date){
        if (date <= 0) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm");
        return dateFormat.format(new Date(date));
    }
}
