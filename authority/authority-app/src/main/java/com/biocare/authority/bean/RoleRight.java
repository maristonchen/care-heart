package com.biocare.authority.bean;

/**
 * 角色权限实体类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 14:05
 */
public class RoleRight {

    /**
     * 主键
     */
    private String rrId;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 权限ID
     */
    private String rightId;

    public String getRrId() {
        return rrId;
    }

    public void setRrId(String rrId) {
        this.rrId = rrId;
    }

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
