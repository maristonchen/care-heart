package com.biocare.authority.bean;

/**
 * 用户角色实体类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 14:02
 */
public class LoginRole {

    /**
     * 主键
     */
    private String urId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private String roleId;

    public String getUrId() {
        return urId;
    }

    public void setUrId(String urId) {
        this.urId = urId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
