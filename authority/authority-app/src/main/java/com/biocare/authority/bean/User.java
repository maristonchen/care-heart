package com.biocare.authority.bean;

/**
 * 用户信息实体
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 10:39
 */
public class User {

    /**
     * 主键
     */
    private String userId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 真实姓名
     */
    private String realName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
