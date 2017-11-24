package com.biocare.authority.mapper;

import com.biocare.authority.bean.User;
import com.biocare.authority.query.UserQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 用户Mapper
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 10:53
 */
@Repository
@Meta(tableName = "t_user_info",keyProperty = "userId")
public interface UserMapper extends BaseMapper<User,UserQuery>{
}
