package com.biocare.authority.bean;

import com.alibaba.fastjson.JSON;

/**
 * 用户组
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/19 15:58
 */
public class Group {

    /**
     * 主键
     */
    private String groupId;

    /**
     * 用户组名称
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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
