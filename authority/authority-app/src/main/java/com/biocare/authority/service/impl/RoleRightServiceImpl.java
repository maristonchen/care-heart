package com.biocare.authority.service.impl;

import com.biocare.authority.bean.RoleRight;
import com.biocare.authority.mapper.RoleRightMapper;
import com.biocare.authority.query.RoleRightQuery;
import com.biocare.authority.service.RoleRightService;
import com.biocare.common.utils.UniqueNoUtil;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 角色权限业务接口实现类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 14:25
 */
@Service("rRoleRightService")
public class RoleRightServiceImpl extends AbstractBaseService<RoleRight,RoleRightQuery> implements RoleRightService{

    /**
     * 角色权限Mapper
     */
    @Resource
    private RoleRightMapper roleRightMapper;

    /**
     * 获取角色权限业务Mapp
     * @return
     */
    @Override
    protected BaseMapper<RoleRight, RoleRightQuery> getMapper() {
        return this.roleRightMapper;
    }

    /**
     * 重写插入方法，设置自定义主键
     * @param roleRight
     */
    @Override
    public void save(RoleRight roleRight) {
        roleRight.setRrId(UniqueNoUtil.genNumber(UniqueNoUtil.T_ROLE_RIGHT_INFO));
        super.save(roleRight);
    }
}
