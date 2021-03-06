package com.biocare.authority.mapper;

import com.biocare.authority.bean.Login;
import com.biocare.authority.query.LoginQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.enumtype.GenerationType;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 登录用户Mapper
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 13:34
 */
@Repository
@Meta(tableName = "t_login_info",keyProperty = "userId",keyStrategy = GenerationType.CUSTOM)
public interface LoginMapper extends BaseMapper<Login,LoginQuery>{
}
