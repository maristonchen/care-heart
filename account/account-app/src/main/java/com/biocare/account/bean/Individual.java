package com.biocare.account.bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * individual
 *
 * @author mariston
 * @version 1.0
 * @since 2017/10/31
 */
public class Individual implements Serializable {

    private static final long serialVersionUID = -4942887576325594958L;
    /**
     * 用户ID
     */
    private String individualId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别  1-男性 0-女性
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
    private String birthday;


    public String getIndividualId() {
        return individualId;
    }

    public void setIndividualId(String individualId) {
        this.individualId = individualId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
