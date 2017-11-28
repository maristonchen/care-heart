package com.biocare.authority.service.impl;

import com.biocare.authority.bean.Role;
import com.biocare.authority.mapper.RoleMapper;
import com.biocare.authority.query.RoleQuery;
import com.biocare.authority.service.RoleService;
import com.biocare.common.utils.UniqueNoUtil;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色业务接口实现类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 14:45
 */
@Service("roleService")
public class RoleServiceImpl extends AbstractBaseService<Role,RoleQuery> implements RoleService{

    /**
     * 角色Mapper
     * @return
     */
    @Resource
    private RoleMapper roleMapper;

    /**
     * 获取角色Mapper
     * @return
     */
    @Override
    protected BaseMapper<Role, RoleQuery> getMapper() {
        return this.roleMapper;
    }

    /**
     * 重写插入方法，设置自定义主键
     * @param role 角色
     */
    @Override
    public void save(Role role) {
        role.setRoleId(UniqueNoUtil.genNumber(UniqueNoUtil.T_ROLE_INFO));
        super.save(role);
    }
}
