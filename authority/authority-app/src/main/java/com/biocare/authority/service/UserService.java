package com.biocare.authority.service;

import com.biocare.authority.bean.User;
import com.biocare.authority.query.UserQuery;
import com.yhxd.tools.mybatis.service.BaseService;

/**
 * 用户业务接口
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 10:59
 */
public interface UserService extends BaseService<User,UserQuery> {
}
