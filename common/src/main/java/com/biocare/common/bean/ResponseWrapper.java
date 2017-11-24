package com.biocare.common.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.biocare.common.em.ErrorCode;
import com.biocare.common.em.GlobalErrorCode;
import com.biocare.common.exception.BioException;
import com.yhxd.tools.base.encrypt.MD5;
import com.yhxd.tools.base.string.StringUtil;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/19 16:29
 */
public class ResponseWrapper implements Serializable {

    private static final long serialVersionUID = 7147083969363877101L;

    /**
     * error code
     */
    private String code;

    /**
     * error message
     */
    private String msg;

    /**
     * MD5 sign
     */
    private String sign;

    /**
     * response
     */
    private String result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ResponseWrapper create(Exception e) {
        ResponseWrapper wrapper;
        if (e instanceof BioException) {
            BioException bioException = (BioException) e;
            wrapper = create(bioException);
        }else{
            wrapper = create(GlobalErrorCode.FAIL);
        }
        return wrapper;
    }

    public static ResponseWrapper create(BioException e) {
        return create(e.getErrorCode());
    }

    public static ResponseWrapper create(ErrorCode errorCode) {
        return create(errorCode.getCode(), errorCode.getMsg(), null);
    }

    public static ResponseWrapper create(ErrorCode errorCode, Object result) {
        return create(errorCode.getCode(), errorCode.getMsg(), result);
    }

    private static ResponseWrapper create(String code, String msg, Object result) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.code = code;
        responseWrapper.msg = msg;
        responseWrapper.result = result == null ? StringUtil.EMPTY : JSON.toJSONString(result);
        responseWrapper.sign = MD5.md5(responseWrapper.result);
        return responseWrapper;
    }

    public <T> T getResult(Class<T> clazz) {
        Assert.isTrue(StringUtil.equals(this.sign, MD5.md5(this.result)), "the result is mismatch");
        return StringUtil.isNotBlank(result) ? JSON.parseObject(result, clazz) : null;
    }

    public String getResult() {
        Assert.isTrue(StringUtil.equals(this.sign, MD5.md5(this.result)), "the result is mismatch");
        return result;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }
}
