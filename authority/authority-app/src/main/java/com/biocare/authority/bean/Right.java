package com.biocare.authority.bean;

import com.alibaba.fastjson.JSON;

/**
 * 权限实体类
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/19 16:05
 */
public class Right {

    /**
     * 权限ID
     */
    private String rightId;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 地址
     */
    private String url;

    /**
     * 标签
     */
    private String tag;

    /**
     * 父ID
     */
    private String parentId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 子系统ID
     */
    private String sysId;

    public String getRightId() {
        return rightId;
    }

    public void setRightId(String rightId) {
        this.rightId = rightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
