package com.biocare.authority.handler.impl;

import com.biocare.authority.bean.*;
import com.biocare.authority.handler.MenuHandler;
import com.biocare.authority.query.RoleRightQuery;
import com.biocare.authority.query.UserQuery;
import com.biocare.authority.query.UserRoleQuery;
import com.biocare.authority.service.*;
import com.biocare.common.em.GlobalErrorCode;
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
     * 用户业务接口
     */
    @Resource
    private UserService userService;

    /**
     * 权限业务接口
     */
    @Resource
    private RightServcie rightServcie;

    /**
     * 用户角色业务接口
     */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 角色权限业务接口
     */
    @Resource
    private RoleRightService roleRightService;


    /**
     * 根据用户名查询用户拥有的权限
     *
     * @param userName 用户名
     * @return
     */
    @Override
    public List<Right> listRight(String userName) {

        //校验参数
        BioAssert.hasText(userName, GlobalErrorCode.NAME_EMPTY_ERROR);

        //定义权限信息集合
        List<Right> rights=new ArrayList<Right>();

        //查询用户信息
        UserQuery userQuery = new UserQuery();
        userQuery.setName(userName);
        List<User> userList= userService.queryList(userQuery);
        BioAssert.notEmpty(userList,GlobalErrorCode.USER_EMPTY_ERROR);

        //查询用户拥有的角色信息
        UserRoleQuery userRoleQuery=new UserRoleQuery();
        userRoleQuery.setUserId(userList.get(0).getUserId());
        List<UserRole> userRoleList=userRoleService.queryList(userRoleQuery);
        BioAssert.notEmpty(userList,GlobalErrorCode.ROLE_EMPTY_ERROR);
        for (UserRole userRole:userRoleList) {

            //查询角色拥有的权限信息
            RoleRightQuery roleRightQuery=new RoleRightQuery();
            roleRightQuery.setRoleId(userRole.getRoleId());
            List<RoleRight> roleRightList=roleRightService.queryList(roleRightQuery);
            BioAssert.notEmpty(userList,GlobalErrorCode.RIGHT_EMPTY_ERROR);
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
