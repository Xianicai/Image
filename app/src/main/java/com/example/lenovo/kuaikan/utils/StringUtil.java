package com.example.lenovo.kuaikan.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * @param time 毫秒
     * @return
     */
    public static String convertTime(long time) {
        long currentTime = time;

        //秒
        int s = (int) (currentTime / 1000);
        //分
        int m = s / 60;
        //小时
        int h = m / 60;
        //天
        int d = h / 24;
        //月
        int M = d / 30;
        //年
        int y = M / 12;

        if (y > 0) {
            return y + "年";
        }
        if (M > 0) {
            return M + "个月";
        }
        if (d > 0) {
            return d + "天";
        }
        if (h > 0) {
            return h + "小时";
        }
        if (m > 0) {
            return m + "分";
        }
        if (s > 0) {
            return s + "秒";
        }
        return time + "";
    }

    /**
     * 判断是否为空串（会对字符串进行trim()）
     *
     * @param str 需要判断的 字符串
     */
    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * 判断是否为空串（会对字符串进行trim()）
     *
     * @param str 需要判断的 字符串
     * @return true不为空；false为""或者null
     */
    public static boolean isNotBlank(String str) {
        return str != null && !"".equals(str.trim());
    }

    /**
     * 判断多个字符串是否都不为空
     * @param strings
     * @return
     */
    public static boolean areAllNotBlank(String... strings) {
        if (strings == null) {
            return false;
        }
        for (String s : strings) {
            if (isBlank(s)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否为空串（不会对字符串进行trim()）
     *
     * @param str 需要判断的 字符串
     * @return true为""或者null
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断是否为空串（不会对字符串进行trim()）
     *
     * @param str 需要判断的 字符串
     * @return true不为空；false为""或者null
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !"".equals(str);
    }

    public static boolean startWith(String str, String prefix) {
        return !(str == null || prefix == null) && str.startsWith(prefix);
    }

    public static boolean isHttp(String url) {
        return startWith(url, "http");
    }

    /**
     * 获取文件/路径的后缀名
     */
    public static String getExt(String str) {
        if (isBlank(str)) {
            return null;
        }
        return str.substring(str.lastIndexOf("."), str.length() - 1);
    }



    /**
     * 判断一个String是否为小数
     *
     * @param str 要判断的String串
     * @return 是小数返回true，否则返回false;
     */
    public static boolean isDecimal(String str) {
        if (isBlank(str)) {
            return false;
        }
        try {
            Pattern p = Pattern.compile("[0-9]+\\.{1}[0-9]+");
            Matcher m = p.matcher(str);
            if (m.matches()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 去除字符串中的空格、回车、换行符、制表符
     */
    public static String getStringWithoutEnter(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 将数字保留两位小数
     */
    public static String parseNumber(double number) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(number);
    }

    /**
     * 将数组用","拼接起来
     */
    public static String join(Object[] arr) {
        return join(arr, ",");
    }

    /**
     * 将数组转换成字符串，并将在中间插入分隔符
     *
     * @param arr       数组
     * @param separator 分隔符
     * @return
     */
    public static String join(Object[] arr, String separator) {
        if (arr != null && isNotBlank(separator)) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : arr) {
                if (obj != null) {
                    sb.append(separator);
                    sb.append(obj);
                }
            }
            if (sb.length() > 0) {
                return sb.substring(separator.length());
            }
        }
        return "";
    }


    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    /**
     * 1.str1 == null || str2 == null，retrun false<br>
     * 2.str1 == str2，return true<br>
     * else.return str1.equals(str2)
     */
    public static boolean equals(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1 == str2) {
            return true;
        }
        return str1.equals(str2);
    }

    /**
     * 统计字符串长度，可以统计中文 中文为2个字符，英文为1个字符
     */
    public static int countUTF8StringLength(String str) {
        int m = 0;
        char arr[] = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if ((c >= 0x0391 && c <= 0xFFE5)) // 中文字符
            {
                m = m + 2;
            } else if ((c >= 0x0000 && c <= 0x00FF)) // 英文字符
            {
                m = m + 1;
            }
        }
        return m;
    }

    /**
     * 判断str是否为空，为空则返回""；否则返回str
     */
    public static String getString(String str) {
        return getString(str, null);
    }

    /**
     * 判断str是否为空，为空则返回def；否则返回str
     */
    public static String getString(String str, String def) {
        if (isNotBlank(str)) {
            return str;
        }
        if (isBlank(def)) {
            def = "";
        }
        return def;
    }

    /**
     * 截取" 字节"的方法,注意 不是字符截取
     */
    public static String getSubString(String str, int pstart, int pend) {
        String resu = "";
        int beg = 0;
        int end = 0;
        int count1 = 0;
        char[] temp = new char[str.length()];
        str.getChars(0, str.length(), temp, 0);
        boolean[] bol = new boolean[str.length()];
        for (int i = 0; i < temp.length; i++) {
            bol[i] = false;
            if ((int) temp[i] > 255) {// 说明是中文
                count1++;
                bol[i] = true;
            }
        }
        if (pstart > str.length() + count1) {
            resu = null;
        }
        if (pstart > pend) {
            resu = null;
        }
        if (pstart < 1) {
            beg = 0;
        } else {
            beg = pstart - 1;
        }
        if (pend > str.length() + count1) {
            end = str.length() + count1;
        } else {
            end = pend;// 在substring的末尾一样
        }
        // 下面开始求应该返回的字符串
        if (resu != null) {
            if (beg == end) {
                int count = 0;
                if (beg == 0) {
                    if (bol[0] == true)
                        resu = null;
                    else
                        resu = new String(temp, 0, 1);
                } else {
                    int len = beg;// zheli
                    for (int y = 0; y < len; y++) {// 表示他前面是否有中文,不管自己
                        if (bol[y] == true)
                            count++;
                        len--;// 想明白为什么len--
                    }
                    // for循环运行完毕后，len的值就代表在正常字符串中，目标beg的上一字符的索引值
                    if (count == 0) {// 说明前面没有中文
                        if ((int) temp[beg] > 255) // 说明自己是中文
                            resu = null;// 返回空
                        else
                            resu = new String(temp, beg, 1);
                    } else {// 前面有中文，那么一个中文应与2个字符相对
                        if ((int) temp[len + 1] > 255) // 说明自己是中文
                            resu = null;// 返回空
                        else
                            resu = new String(temp, len + 1, 1);
                    }
                }
            } else {// 下面是正常情况下的比较
                int temSt = beg;
                int temEd = end - 1;// 这里减掉一
                for (int i = 0; i < temSt; i++) {
                    if (bol[i] == true)
                        temSt--;
                } // 循环完毕后temSt表示前字符的正常索引
                for (int j = 0; j < temEd; j++) {
                    if (bol[j] == true)
                        temEd--;
                } // 循环完毕后temEd-1表示最后字符的正常索引
                if (bol[temSt] == true) // 说明是字符，说明索引本身是汉字的后半部分，那么应该是不能取的
                {
                    int cont = 0;
                    for (int i = 0; i <= temSt; i++) {
                        cont++;
                        if (bol[i] == true)
                            cont++;
                    }
                    if (pstart == cont) // 是偶数不应包含,如果pstart<cont则要包含
                        temSt++;// 从下一位开始
                }
                if (bol[temEd] == true) {// 因为temEd表示substring
                    // 的最面参数，此处是一个汉字，下面要确定是否应该含这个汉字
                    int cont = 0;
                    for (int i = 0; i <= temEd; i++) {
                        cont++;
                        if (bol[i] == true)
                            cont++;
                    }
                    if (pend < cont) // 是汉字的前半部分不应包含
                        temEd--;// 所以只取到前一个
                }
                if (temSt == temEd) {
                    resu = new String(temp, temSt, 1);
                } else if (temSt > temEd) {
                    resu = null;
                } else {
                    resu = str.substring(temSt, temEd + 1);
                }
            }
        }
        return resu;// 返回结果
    }

    /**
     * 去除特殊字符，首行缩进 ："\\s*|\t|\r|\n" 有问题
     *
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 将两个字符串拼成一个字符串（会将null换成""）
     */
    public static String append(String str1, String str2) {
        return (str1 == null ? "" : str1) + (str2 == null ? "" : str2);
    }

    /**
     * @param str
     * @param maxLength 要显示的字的个数
     * @return
     */
    public static String ellipsizeEnd(String str, int maxLength) {
        if (isBlank(str)) {
            return str;
        }
        if (str.length() <= maxLength) {
            return str;
        } else {
            return str.substring(0, maxLength) + "...";
        }
    }

    /**
     * 讲大于等于0的double转成带有两位小数的string
     */
    public static String doubleToString(double d) {
        String s = "0.00";
        if (d >= 0) {
            DecimalFormat df = new DecimalFormat("######0.00");
            s = df.format(d);
        }
        return s;
    }

    /**
     * 在url后面拼接参数，假如url中带有?则拼"&params"，否则拼"?params"
     */
    public static String appendParams(String url, String params) {
        if (url.contains("?")) {
            url += "&";
        } else {
            url += "?";
        }
        url += params;
        return url;
    }

    public static final Pattern PATTERN_URL = Pattern.compile("(http://|https://|www\\.)[^\\u4e00-\\u9fa5,^\\s,^\\[,^\\]]+|[^\\u4e00-\\u9fa5,^\\s,^\\[,^\\]]+(.com|.cn|.org|.info|.net|.gov|.edu)[^\\u4e00-\\u9fa5,^\\s,^\\[,^\\]]*");

    public static boolean isUrl(String input) {
        if (input == null) {
            return false;
        }
        Matcher mAtMatcher = PATTERN_URL.matcher(input);
        while (mAtMatcher.find()) {
            return true;
        }
        return false;
    }

    public static String decode(String str) {
        try {
            str = str.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
            str = str.replaceAll("\\+", "%2B");
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String encode(String str) {
        try {
            if (isNotBlank(str)) {
                return URLEncoder.encode(str, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 使json字符串规范化，去掉引号、反斜杠、\r、\n
     */
    public static String jsonCanonicalize(String json) {
        if (isBlank(json)) {
            return "{}";
        }
        json = json.replace("\\", "\\\\")   // 替换反斜杠
                .replace("\r", "\\\r")      // 替换\r
                .replace("\n", "\\\n");     // 替换\n
        // 替换value中的双引号，正则表达式最后的}前面的\\是转义符，不转义的话在Java环境可以通过，但Android环境会报错
        Pattern pattern = Pattern.compile("(?<=:\\s?\").*?(?=\"\\s?,|\"\\s?\\})");
        Matcher matcher = pattern.matcher(json);
        while (matcher.find()) {
            String target = matcher.group();
            json = json.replace(target, target.replace("\"", "\\\""));
        }
        return json;
    }
}
