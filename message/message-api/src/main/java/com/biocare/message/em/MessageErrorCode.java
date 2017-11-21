package com.biocare.message.em;

import com.biocare.common.em.ErrorCode;
import com.yhxd.tools.base.calc.BigDecimalUtil;
import com.yhxd.tools.base.string.StringUtil;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/21 16:42
 */
public enum MessageErrorCode implements ErrorCode {

    EMAIL_TITLE_EMPTY("050001", "email title is empty"),;

    /**
     * error code
     */
    protected String code;

    /**
     * error msg
     */
    protected String msg;


    MessageErrorCode(String code, String msg) {
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
        if (BigDecimalUtil.compareTo(this.getCode(), "050001") < 0 || BigDecimalUtil.compareTo(this.getCode(), "060000") > 0) {
            throw new IllegalStateException("the error code is out of range ,it is " + this.name() + "[" + this.code + "]");
        }
        for (MessageErrorCode acErrorCode : values()) {
            if (StringUtil.equals(acErrorCode.getCode(), this.getCode()) && !this.equals(acErrorCode)) {
                throw new IllegalStateException("the error code is repeated,the other is " + acErrorCode.name() + "[" + acErrorCode.code + "]");
            }
        }
    }
}
