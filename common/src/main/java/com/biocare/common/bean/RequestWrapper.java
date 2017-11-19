package com.biocare.common.bean;

import com.alibaba.fastjson.JSON;
import com.yhxd.tools.base.encrypt.MD5;
import com.yhxd.tools.base.string.StringUtil;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/19 16:22
 */
public class RequestWrapper implements Serializable {

    private static final long serialVersionUID = -617943184368206923L;

    private String content;

    private String sign;

    public static RequestWrapper create(Object param) {
        RequestWrapper wrapper = new RequestWrapper();
        wrapper.content = param == null ? StringUtil.EMPTY : JSON.toJSONString(param);
        wrapper.sign = MD5.md5(wrapper.content);
        return wrapper;
    }

    public <T> T getContent(Class<T> clazz) {
        Assert.isTrue(StringUtil.equals(this.sign, MD5.md5(this.content)), "param sign is mismatch");
        return StringUtil.isNotBlank(this.content) ? JSON.parseObject(this.content, clazz) : null;
    }

    public String getContent() {
        Assert.isTrue(StringUtil.equals(this.sign, MD5.md5(this.content)), "param sign is mismatch");
        return content;
    }

}
