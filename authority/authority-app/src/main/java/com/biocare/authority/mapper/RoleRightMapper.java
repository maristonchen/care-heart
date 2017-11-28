package com.biocare.authority.mapper;

import com.biocare.authority.bean.RoleRight;
import com.biocare.authority.query.RoleRightQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.enumtype.GenerationType;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 角色权限Mapepr
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 14:15
 */
@Repository
@Meta(tableName = "t_role_right_info",keyProperty = "rrId",keyStrategy = GenerationType.CUSTOM)
public interface RoleRightMapper extends BaseMapper<RoleRight,RoleRightQuery>{
}
