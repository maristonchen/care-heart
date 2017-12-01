package com.biocare.authority.mapper;

import com.biocare.authority.bean.LoginGroup;
import com.biocare.authority.query.LoginGroupQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.enumtype.GenerationType;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 登录用户、用户组关系表Mapper
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/30 14:42
 */
@Repository
@Meta(tableName = "t_login_group_info",keyProperty = "ugId",keyStrategy = GenerationType.CUSTOM)
public interface LoginGroupMapper extends BaseMapper<LoginGroup,LoginGroupQuery>{
}
