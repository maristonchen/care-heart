package com.biocare.authority.query;

import com.yhxd.tools.mybatis.query.BaseQuery;

/**
 * 角色权限查询实体
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 14:08
 */
public class RoleRightQuery extends BaseQuery{

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 权限ID
     */
    private String rightId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRightId() {
        return rightId;
    }

    public void setRightId(String rightId) {
        this.rightId = rightId;
    }
}
