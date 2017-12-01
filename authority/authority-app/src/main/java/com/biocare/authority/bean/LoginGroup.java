package com.biocare.authority.bean;

import com.alibaba.fastjson.JSON;

/**
 * 登录用户、用户组关联实体
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/30 14:12
 */
public class LoginGroup {

    /**
     * 主键
     */
    private String ugId;

    /**
     * 登录用户ID
     */
    private String userId;

    /**
     * 用户组ID
     */
    private String groupId;

    public String getUgId() {
        return ugId;
    }

    public void setUgId(String ugId) {
        this.ugId = ugId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
