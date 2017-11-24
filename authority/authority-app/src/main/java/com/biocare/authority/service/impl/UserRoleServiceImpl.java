package com.biocare.authority.service.impl;

import com.biocare.authority.bean.UserRole;
import com.biocare.authority.mapper.UserRoleMapper;
import com.biocare.authority.query.UserRoleQuery;
import com.biocare.authority.service.UserRoleService;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 用户角色接口业务实现类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 14:19
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends AbstractBaseService<UserRole,UserRoleQuery> implements UserRoleService{

    /**
     * 用户角色Mapper
     */
    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * 获取用户角色Mapper
     * @return
     */
    @Override
    protected BaseMapper<UserRole, UserRoleQuery> getMapper() {
        return this.userRoleMapper;
    }
}
