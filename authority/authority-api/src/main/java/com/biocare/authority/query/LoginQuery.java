package com.biocare.authority.query;

import com.yhxd.tools.mybatis.query.BaseQuery;

/**
 * 登录查询实体
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 11:40
 */
public class LoginQuery extends BaseQuery{

    /**
     * 用户名
     */
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
