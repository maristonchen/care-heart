package com.biocare.account.em;

import com.biocare.common.em.ErrorCode;
import com.yhxd.tools.base.calc.BigDecimalUtil;
import com.yhxd.tools.base.string.StringUtil;

/**
 * account error code
 * <p>
 * range:['000001','010000']
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/21 13:56
 */
public enum AccountErrorCode implements ErrorCode {

    INDIVIDUAL_NAME_EMPTY("000001", "individual name is empty"),
    INDIVIDUAL_MOBILE_EMPTY("000002", "individual mobile is empty"),;


    /**
     * error code
     */
    protected String code;

    /**
     * error msg
     */
    protected String msg;


    AccountErrorCode(String code, String msg) {
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
        if (BigDecimalUtil.compareTo(this.getCode(), "000001") < 0 || BigDecimalUtil.compareTo(this.getCode(), "010000") > 0) {
            throw new IllegalStateException("the error code is out of range ,it is " + this.name() + "[" + this.code + "]");
        }
        for (AccountErrorCode acErrorCode : values()) {
            if (StringUtil.equals(acErrorCode.getCode(), this.getCode()) && !this.equals(acErrorCode)) {
                throw new IllegalStateException("the error code is repeated,the other is " + acErrorCode.name() + "[" + acErrorCode.code + "]");
            }
        }
    }
}
