package com.biocare.authority.mapper;

import com.biocare.authority.bean.Role;
import com.biocare.authority.query.RoleQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 权限Mapper
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 11:46
 */
@Repository
@Meta(tableName = "t_role_info",keyProperty = "roleId")
public interface RoleMapper extends BaseMapper<Role,RoleQuery> {
}
