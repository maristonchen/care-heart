package com.biocare.authority.handler.impl;

import com.biocare.authority.bean.*;
import com.biocare.authority.em.AuthorityErrorCode;
import com.biocare.authority.handler.MenuHandler;
import com.biocare.authority.query.LoginQuery;
import com.biocare.authority.query.RoleRightQuery;
import com.biocare.authority.query.LoginRoleQuery;
import com.biocare.authority.service.*;
import com.biocare.common.utils.BioAssert;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单综合业务接口实现类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 15:45
 */
@Service("menuHandle")
public class MenuHandlerImpl implements MenuHandler{

    /**
     * 登录用户业务接口
     */
    @Resource
    private LoginService loginService;

    /**
     * 权限业务接口
     */
    @Resource
    private RightServcie rightServcie;

    /**
     * 登录用户角色业务接口
     */
    @Resource
    private LoginRoleService loginRoleService;

    /**
     * 角色权限业务接口
     */
    @Resource
    private RoleRightService roleRightService;


    /**
     * 根据用户名查询用户拥有的权限
     *
     * @param username 用户名
     * @return
     */
    @Override
    public List<Right> listRight(String username) {

        //校验参数
        BioAssert.hasText(username, AuthorityErrorCode.NAME_EMPTY_ERROR);

        //定义权限信息集合
        List<Right> rights=new ArrayList<Right>();

        //查询用户信息
        LoginQuery loginQuery = new LoginQuery();
        loginQuery.setUsername(username);
        List<Login> loginList= loginService.queryList(loginQuery);
        BioAssert.notEmpty(loginList, AuthorityErrorCode.USER_EMPTY_ERROR);

        //查询用户拥有的角色信息
        LoginRoleQuery loginRoleQuery=new LoginRoleQuery();
        loginRoleQuery.setUserId(loginList.get(0).getUserId());
        List<LoginRole> loginRoleList=loginRoleService.queryList(loginRoleQuery);
        BioAssert.notEmpty(loginList,AuthorityErrorCode.ROLE_EMPTY_ERROR);
        for (LoginRole loginRole:loginRoleList) {

            //查询角色拥有的权限信息
            RoleRightQuery roleRightQuery=new RoleRightQuery();
            roleRightQuery.setRoleId(loginRole.getRoleId());
            List<RoleRight> roleRightList=roleRightService.queryList(roleRightQuery);
            BioAssert.notEmpty(loginList,AuthorityErrorCode.RIGHT_EMPTY_ERROR);
            for (RoleRight roleRight:roleRightList) {

                //查询权限信息
                Right right = rightServcie.queryById(roleRight.getRightId());

                //添加权限到权限容器中
                rights.add(right);
            }
        }

        return rights;
    }
}
