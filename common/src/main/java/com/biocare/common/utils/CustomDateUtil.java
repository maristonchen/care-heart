package com.biocare.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * 日期工具类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/27 14:08
 */
public abstract class CustomDateUtil {

    /**
     * 默认的年月日时分秒格式
     */
    public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认的年月日格式
     */
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 紧凑的年月日时分秒格式
     */
    public static final String TIGHT_DATETIME_PATTERN = "yyyyMMddHHmmss";

    /**
     * 紧凑的年月日时分秒毫秒格式
     */
    public static final String TIGHT_DATETIME_SECOND_PATTERN = "yyyyMMddHHmmssSSS";

    /**
     * 紧凑的年月日格式
     */
    public static final String TIGHT_DATE_PATTERN = "yyyyMMdd";

    /**
     * Timestamp格式日期
     */
    public static final String TIMESTAMP = "dd-MM月-yy h:mm:ss.SSS a";

    /**
     * yy-MM-dd HH:mm 格式
     */
    public static final String DATE_TIME_517 = "yy-MM-dd HH:mm";

    /**
     * 简单yyyy-M-d HH:mm:ss  格式
     */
    public static final String SIMPLE_DATETIME_PATTERN = "yyyy-M-d HH:mm:ss";

    /**
     * 获取默认格式("yyyy-MM-dd HH:mm:ss")的当前年月日时分秒
     *
     * @return string
     */
    public static String currentDateTime() {
        return currentDateTime(DEFAULT_DATETIME_PATTERN);
    }

    /**
     * 获取当前年月日时分秒
     *
     * @param pattern 日期格式
     * @return string
     */
    public static String currentDateTime(String pattern) {
        return DateFormatUtils.format(System.currentTimeMillis(), pattern);
    }

    /**
     * 获取当前年月日
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return string
     */
    public static String currentDateTime(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 获取默认格式("yyyy-MM-dd")的当前年月日
     *
     * @return string
     */
    public static String currentDate() {
        return currentDate(DEFAULT_DATE_PATTERN);
    }

    /**
     * 获取当前年月日
     *
     * @param pattern 日期格式
     * @return string
     */
    public static String currentDate(String pattern) {
        return DateFormatUtils.format(System.currentTimeMillis(), pattern);
    }


    /**
     * 今天
     *
     * @return today
     */
    public static Date today() {
        return new Date(System.currentTimeMillis());
    }
}
