package com.biocare.authority.bean;

import com.alibaba.fastjson.JSON;

/**
 * 用户组、权限关联实体
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/30 14:15
 */
public class GroupRight {

    /**
     * 主键
     */
    private String grId;

    /**
     * 用户组ID
     */
    private String groupId;

    /**
     * 权限ID
     */
    private String rightId;

    /**
     * 子系统ID
     */
    private String sysId;

    public String getGrId() {
        return grId;
    }

    public void setGrId(String grId) {
        this.grId = grId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getRightId() {
        return rightId;
    }

    public void setRightId(String rightId) {
        this.rightId = rightId;
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
