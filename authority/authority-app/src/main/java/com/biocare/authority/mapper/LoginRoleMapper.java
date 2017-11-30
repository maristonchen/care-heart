package com.biocare.authority.mapper;

import com.biocare.authority.bean.LoginRole;
import com.biocare.authority.query.LoginRoleQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.enumtype.GenerationType;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 登录用户角色Mapper
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 14:10
 */
@Repository
@Meta(tableName = "t_login_role_info",keyProperty = "urId",keyStrategy = GenerationType.CUSTOM)
public interface LoginRoleMapper extends BaseMapper<LoginRole,LoginRoleQuery>{
}
