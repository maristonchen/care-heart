package com.biocare.platform.bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * banner ad
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 17:25
 */
public class Banner implements Serializable {

    private static final long serialVersionUID = -1118520615207297105L;

    /**
     * banner id
     */
    private String bannerId;

    /**
     * system id
     */
    private String systemId;

    /**
     *  the url of the picture
     */
    private String picUrl;

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
