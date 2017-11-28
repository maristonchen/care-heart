package com.biocare.authority.service.impl;

import com.biocare.authority.bean.Login;
import com.biocare.authority.mapper.LoginMapper;
import com.biocare.authority.query.LoginQuery;
import com.biocare.authority.service.LoginService;
import com.biocare.common.utils.UniqueNoUtil;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 登录业务接口实现类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 14:37
 */
@Service("loginService")
public class LoginServiceImpl extends AbstractBaseService<Login,LoginQuery> implements LoginService{

    /**
     * 登录Mapper
     */
    @Resource
    private LoginMapper loginMapper;

    /**
     * 获取登录Mapper
     * @return
     */
    @Override
    protected BaseMapper<Login, LoginQuery> getMapper() {
        return this.loginMapper;
    }

    /**
     * 重写插入方法，设置自定义主键
     * @param login 登录
     */
    @Override
    public void save(Login login) {
        login.setUserId(UniqueNoUtil.genNumber(UniqueNoUtil.T_LOGIN_INTO));
        super.save(login);
    }
}
