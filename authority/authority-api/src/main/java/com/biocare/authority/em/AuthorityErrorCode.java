package com.biocare.authority.em;

import com.biocare.common.em.ErrorCode;
import com.yhxd.tools.base.calc.BigDecimalUtil;
import com.yhxd.tools.base.string.StringUtil;

/**
 * authority system error code
 *
 * range:['010001,'020000']
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/21 15:15
 */
public enum AuthorityErrorCode implements ErrorCode {

    SUCCESS("010001", "the operation is successful"),
    FAIL("010002", "the operation is failed"),
    NAME_EMPTY_ERROR("010003","登录用户名为空！"),
    USER_EMPTY_ERROR("010004","用户信息为空！"),
    ROLE_EMPTY_ERROR("010005","角色信息为空！"),
    RIGHT_EMPTY_ERROR("010006","权限信息为空！" ),
    PHONENO_EMPTY_ERROR("010007","手机号为空！" ),
    LOGIN_EMPTY_ERROR("010008","登录信息为空！" ),
    USERNAME_PASSWORD_ERROR("010009","用户名或密码错误！" ),
    LOGIN_SUCCESS("010010","登录成功！" );

    /**
     * error code
     */
    protected String code;

    /**
     * error msg
     */
    protected String msg;


    AuthorityErrorCode(String code, String msg) {
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
        if (BigDecimalUtil.compareTo(this.getCode(), "010001") < 0 || BigDecimalUtil.compareTo(this.getCode(), "020000") > 0) {
            throw new IllegalStateException("the error code is out of range ,it is " + this.name() + "[" + this.code + "]");
        }
        for (AuthorityErrorCode acErrorCode : values()) {
            if (StringUtil.equals(acErrorCode.getCode(), this.getCode()) && !this.equals(acErrorCode)) {
                throw new IllegalStateException("the error code is repeated,the other is " + acErrorCode.name() + "[" + acErrorCode.code + "]");
            }
        }
    }
}
