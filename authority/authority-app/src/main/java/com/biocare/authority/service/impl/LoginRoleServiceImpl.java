package com.biocare.authority.service.impl;

import com.biocare.authority.bean.LoginRole;
import com.biocare.authority.mapper.LoginRoleMapper;
import com.biocare.authority.query.LoginRoleQuery;
import com.biocare.authority.service.LoginRoleService;
import com.biocare.common.utils.UniqueNoUtil;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 登录用户角色接口业务实现类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 14:19
 */
@Service("loginRoleService")
public class LoginRoleServiceImpl extends AbstractBaseService<LoginRole,LoginRoleQuery> implements LoginRoleService {

    /**
     * 登录用户角色Mapper
     */
    @Resource
    private LoginRoleMapper loginRoleMapper;

    /**
     * 获取登录用户角色Mapper
     * @return
     */
    @Override
    protected BaseMapper<LoginRole, LoginRoleQuery> getMapper() {
        return this.loginRoleMapper;
    }

    /**
     * 重写插入方法，设置自定义主键
     * @param loginRole 登录用户角色
     */
    @Override
    public void save(LoginRole loginRole) {
        loginRole.setUrId(UniqueNoUtil.genNumber(UniqueNoUtil.T_LOGIN_ROLE_INFO));
        super.save(loginRole);
    }
}
