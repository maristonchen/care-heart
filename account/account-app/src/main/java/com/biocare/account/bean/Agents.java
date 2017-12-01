package com.biocare.account.bean;

import com.alibaba.fastjson.JSON;

/**
 * 代理商实体类
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/7 15:07
 */
public class Agents {

    /**
     * 主键
     */
    private String agentId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 企业Logo
     */
    private String logo;

    /**
     * 代理商名称
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 地址
     */
    private String address;

    /**
     * 成立时间
     */
    private String establishTime;

    /**
     * 企业说明
     */
    private String introduction;

    /**
     * 证明材料
     */
    private String material;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(String establishTime) {
        this.establishTime = establishTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
