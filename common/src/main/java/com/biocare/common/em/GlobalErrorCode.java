package com.biocare.common.em;

import com.yhxd.tools.base.calc.BigDecimalUtil;
import com.yhxd.tools.base.string.StringUtil;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/21 14:48
 */
public enum GlobalErrorCode implements ErrorCode {
    SUCCESS("000000", "the operation is successful"),
    FAIL("999999", "the operation is failed");

    /**
     * error code
     */
    protected String code;

    /**
     * error msg
     */
    protected String msg;


    GlobalErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * get error code
     *
     * @return string
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * get error message
     *
     * @return string
     */
    @Override
    public String getMsg() {
        return this.msg;
    }

    /**
     * Check if the code is repeated and the range of code
     */
    @Override
    public void check() {
        if ((BigDecimalUtil.compareTo(this.getCode(), "900000") < 0 || BigDecimalUtil.compareTo(this.getCode(), "999999") > 0)
                && BigDecimalUtil.compareTo(this.getCode(), "000000") != 0) {
            throw new IllegalStateException("the error code is out of range ,it is " + this.name() + "[" + this.code + "]");
        }
        for (GlobalErrorCode acErrorCode : values()) {
            if (StringUtil.equals(acErrorCode.getCode(), this.getCode()) && !this.equals(acErrorCode)) {
                throw new IllegalStateException("the error code is repeated,the other is " + acErrorCode.name() + "[" + acErrorCode.code + "]");
            }
        }
    }
}
