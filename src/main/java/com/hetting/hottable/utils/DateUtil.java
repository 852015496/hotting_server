package com.hetting.hottable.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * 日期工具类
 *
 * @author Mr.J
 * @Date 2019/12/7 - 17:28
 */
public class DateUtil {

    /**
     * 返回日期格式化工具
     *
     * @param pattern 日期格式字符串
     * @return 日期格式器对象
     */
    private static SimpleDateFormat getDateFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 获取当前日期时间的字符串
     *
     * @return 字符串
     */
    public static String getDateString() {
        return getDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String getDateStringWithoutSeparate() {
        return getDateFormat("yyMMddHHmmss").format(new Date());
    }

    /**
     * 获取当前日期时间的数组
     *
     * @return 字节数组
     */
    public static byte[] getDateBytes() {
        byte[] bytes = new byte[6];
        DateFormat format = getDateFormat("yy-MM-dd-HH-mm-ss");
        String dateTime = format.format(new Date());
        String[] strings = dateTime.split("-");
        int len = 6;
        for (int i = 0; i < len; i++) {
            bytes[i] = Byte.parseByte(strings[i]);
        }
        return bytes;
    }

    /**
     * 字符串转日期
     *
     * @param dataStr 日期字符串
     * @return 日期
     */
    public static Date getDateFromString(String dataStr) {
        try {
            return getDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串转日期
     *
     * @param dataStr 字符串
     * @return 日期
     */
    public static long getTimeFromString(String dataStr) {
        Date date = getDateFromString(dataStr);
        if (date == null) {
            return 0;
        } else {
            return Objects.requireNonNull(getDateFromString(dataStr)).getTime();
        }
    }

    public static boolean isTargetDate(String dateStr) {
        if (dateStr.length() > 10) {
            dateStr = dateStr.substring(0, 10);
        }
        Calendar calendarNow = Calendar.getInstance();
        calendarNow.setTime(new Date());
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendarTarget = Calendar.getInstance();
        try {
            calendarTarget.setTime(dataFormat.parse(dateStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendarNow.get(Calendar.MONTH) == calendarTarget.get(Calendar.MONTH)
                && calendarNow.get(Calendar.DAY_OF_MONTH) == calendarTarget.get(Calendar.DAY_OF_MONTH);
    }

}
