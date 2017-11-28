package com.biocare.authority.service.impl;

import com.biocare.authority.bean.User;
import com.biocare.authority.mapper.UserMapper;
import com.biocare.authority.query.UserQuery;
import com.biocare.authority.service.UserService;
import com.biocare.common.utils.UniqueNoUtil;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 用户业务接口实现
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 11:00
 */
@Service("userService")
public class UserServiceImpl extends AbstractBaseService<User,UserQuery> implements UserService{

    /**
     * 用户Mapper
     */
    @Resource
    private UserMapper userMapper;

    /**
     * 获取用户Mapper
     * @return
     */
    @Override
    protected BaseMapper<User, UserQuery> getMapper() {
        return this.userMapper;
    }

    /**
     * 重写插入方法，设置自定义主键
     * @param user 用户
     */
    @Override
    public void save(User user) {
        user.setUserId(UniqueNoUtil.genNumber(UniqueNoUtil.T_USER_INFO));
        super.save(user);
    }
}
