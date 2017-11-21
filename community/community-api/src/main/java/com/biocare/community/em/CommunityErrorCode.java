package com.biocare.community.em;

import com.biocare.common.em.ErrorCode;
import com.yhxd.tools.base.calc.BigDecimalUtil;
import com.yhxd.tools.base.string.StringUtil;

/**
 * community system error code
 * <p>
 * range:['020001','030000']
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/21 15:09
 */
public enum CommunityErrorCode implements ErrorCode {

    TOPIC_CONTENT_EMPTY("020001", "the content of the topic  is empty");

    /**
     * error code
     */
    protected String code;

    /**
     * error msg
     */
    protected String msg;


    CommunityErrorCode(String code, String msg) {
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
        if (BigDecimalUtil.compareTo(this.getCode(), "020001") < 0 || BigDecimalUtil.compareTo(this.getCode(), "030000") > 0) {
            throw new IllegalStateException("the error code is out of range ,it is " + this.name() + "[" + this.code + "]");
        }
        for (CommunityErrorCode acErrorCode : values()) {
            if (StringUtil.equals(acErrorCode.getCode(), this.getCode()) && !this.equals(acErrorCode)) {
                throw new IllegalStateException("the error code is repeated,the other is " + acErrorCode.name() + "[" + acErrorCode.code + "]");
            }
        }
    }
}
