package com.biocare.authority.query;

import com.yhxd.tools.mybatis.query.BaseQuery;

/**
 * 用户角色查询实体
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 14:08
 */
public class UserRoleQuery extends BaseQuery{

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private String roleId;

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
