package com.example.eurekaclient.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理工具类
 */
public class DateUtil {
    /**
     * 获取指定格式化时间字符串
     *
     * @param formatString
     * @return
     */
    public static String getFormatDate(String formatString) {
        return getFormatDate(formatString,new Date());
    }

    /**
     * 获取指定date,format格式字符串。
     *
     * @param formatString
     * @param date
     * @return
     */
    public static String getFormatDate(String formatString, Date date) {
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        String dateStr = format.format(date);
        return dateStr;
    }

    /**
     * 获取当前的日期。
     *
     * @return
     */
    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
        return calendar.getTime();
    }
}
