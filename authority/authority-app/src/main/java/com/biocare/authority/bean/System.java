package com.biocare.authority.bean;

/**
 * sub system
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/19 15:52
 */
public class System {

    private String sysId;

    private String name;

    private String url;

    private Integer status;

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
