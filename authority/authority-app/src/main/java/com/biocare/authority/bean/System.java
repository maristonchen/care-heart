package com.biocare.authority.bean;

/**
 * 子系统实体类
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/19 15:52
 */
public class System {

    /**
     * 子系统ID
     */
    private String sysId;

    /**
     * 名称
     */
    private String name;

    /**
     * 路径
     */
    private String url;

    /**
     * 状态
     */
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
