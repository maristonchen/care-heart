package com.biocare.authority.bean;

import com.alibaba.fastjson.JSON;

/**
 * 角色实体类
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/19 15:58
 */
public class Role {

    /**
     * 主键
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
