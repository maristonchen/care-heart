package com.biocare.authority.handler.impl;

import com.biocare.authority.bean.*;
import com.biocare.authority.bean.System;
import com.biocare.authority.dto.TreeMenuDTO;
import com.biocare.authority.em.AuthorityErrorCode;
import com.biocare.authority.handler.MenuHandler;
import com.biocare.authority.query.LoginQuery;
import com.biocare.authority.query.RoleRightQuery;
import com.biocare.authority.query.LoginRoleQuery;
import com.biocare.authority.service.*;
import com.biocare.common.utils.BioAssert;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private RightService rightService;

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
     * 子系统业务接口
     */
    @Resource
    private SystemService systemService;

    /**
     * 根据用户名查询用户拥有的权限
     *
     * @param username 用户名
     * @return
     */
    @Override
    public List<TreeMenuDTO> getTreeMenu(String username) {

        // 定义菜单
        List<TreeMenuDTO> treeMenuList =new ArrayList<TreeMenuDTO>();

        //校验参数
        BioAssert.hasText(username, AuthorityErrorCode.NAME_EMPTY_ERROR);

        //定义权限信息集合
        List<Right> rights=new ArrayList<Right>();

        //定义子系统容器
        Map<String,System> sysMap=new HashMap<String,System>();

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

                //查询角色拥有的子系统
                if(null==sysMap.get(roleRight.getSysId())){
                    System system=systemService.queryById(roleRight.getSysId());
                    sysMap.put(system.getSysId(),system);
                }

                //查询权限信息
                Right right = rightService.queryById(roleRight.getRightId());

                //添加权限到权限容器中
                rights.add(right);
            }
        }

        //将数据转换为树形格式
        formatDataForTree(sysMap,rights,treeMenuList);

        return treeMenuList;
    }


    /**
     * 将数据转换为树形格式
     *
     * @param sysMap 子系统集合
     * @param rights 权限集合
     * @param treeMenuList 树形菜单集合
     */
    private void formatDataForTree(Map<String,System> sysMap,List<Right> rights,List<TreeMenuDTO> treeMenuList) {
        for (System system:sysMap.values()) {
            //设置根节点
            TreeMenuDTO treeMenuDTO =new TreeMenuDTO();
            treeMenuDTO.setId(system.getSysId());
            treeMenuDTO.setName(system.getName());
            treeMenuDTO.setUrl(system.getUrl());
            //获取主节点
            List<TreeMenuDTO> children=getTreeChildren(system.getSysId(),rights);
            if(!CollectionUtils.isEmpty(children)){
                treeMenuDTO.setChildren(children);
            }
            treeMenuList.add(treeMenuDTO);
        }
    }

    /**
     * 获取子节点
     * @param parentId 父ID
     * @param rights 权限集合
     * @return
     */
    private List<TreeMenuDTO> getTreeChildren(String parentId,List<Right> rights){
        List<TreeMenuDTO> childrenList = new ArrayList<TreeMenuDTO>();
        for (Right right:rights) {
            if(StringUtils.equals(parentId,right.getParentId())){
                TreeMenuDTO treeMenuDTO =new TreeMenuDTO();
                treeMenuDTO.setId(right.getRightId());
                treeMenuDTO.setName(right.getName());
                treeMenuDTO.setUrl(right.getUrl());
                List<TreeMenuDTO> children=getTreeChildren(right.getRightId(),rights);
                if(!CollectionUtils.isEmpty(children)){
                    treeMenuDTO.setChildren(children);
                }
                childrenList.add(treeMenuDTO);
            }
        }
        return childrenList;
    }
}
