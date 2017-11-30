package com.biocare.common.utils;

import com.biocare.common.em.GlobalErrorCode;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * 主键生成工具
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/27 14:04
 */
public abstract class UniqueNoUtil {

    /**
     * 主键编号前缀模板(长度为4)
     */
    public static final String T_TABLE_INFO = "TTAI";

    public static final String T_LOGIN_INFO = "TLOI";

    public static final String T_USER_INFO = "TUSI";

    public static final String T_ROLE_INFO = "TROI";

    public static final String T_RIGHT_INFO = "TRII";

    public static final String T_LOGIN_ROLE_INFO = "TLRI";

    public static final String T_ROLE_RIGHT_INFO = "TRRI";

    public static final String T_LOGIN_INTO = "TLOI";

    public static final String T_GROUP_INTO = "TGRI";

    public static final String T_SYSTEM_INTO = "TSYI";

    /**
     * 生成主键编号
     *
     * @param prefix 前缀
     * @return string
     */
    public static String genNumber(String prefix) {
        BioAssert.hasText(prefix, GlobalErrorCode.STRING_PARAM_EMPTY);
        return prefix + CustomDateUtil.currentDateTime(CustomDateUtil.TIGHT_DATETIME_SECOND_PATTERN) + RandomStringUtils.randomNumeric(11);
    }
}
