package com.biocare.authority.service.impl;

import com.biocare.authority.bean.LoginGroup;
import com.biocare.authority.mapper.LoginGroupMapper;
import com.biocare.authority.query.LoginGroupQuery;
import com.biocare.authority.service.LoginGroupService;
import com.biocare.common.utils.UniqueNoUtil;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 到哪儿登录用户用户组业务接口实现类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/30 15:31
 */
@Service("loginGroupService")
public class LoginGroupServiceImpl extends AbstractBaseService<LoginGroup,LoginGroupQuery> implements LoginGroupService{

    /**
     * 登录用户用户组Mapper
     */
   @Resource
   private LoginGroupMapper loginGroupMapper;

    /**
     * 获取登录用户用户组Mapper
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<LoginGroup, LoginGroupQuery> getMapper() {
        return this.loginGroupMapper;
    }

    /**
     * 重写插入方法，设置自定义主键
     * @param loginGroup
     */
    @Override
    public void save(LoginGroup loginGroup) {
        loginGroup.setUgId(UniqueNoUtil.genNumber(UniqueNoUtil.T_LOGIN_GROUP_INFO));
        super.save(loginGroup);
    }
}
