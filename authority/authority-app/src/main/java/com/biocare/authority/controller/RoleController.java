package com.biocare.authority.controller;

import com.biocare.authority.bean.Role;
import com.biocare.authority.bean.RoleRight;
import com.biocare.authority.em.AuthorityErrorCode;
import com.biocare.authority.query.RoleQuery;
import com.biocare.authority.query.RoleRightQuery;
import com.biocare.authority.service.RoleRightService;
import com.biocare.authority.service.RoleService;
import com.biocare.common.exception.BioException;
import com.biocare.common.utils.BioAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

/**
 * 角色控制器
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 17:46
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    /**
     * 角色业务接口
     */
    @Resource
    private RoleService roleService;

    /**
     * 角色权限业务接口
     */
    @Resource
    private RoleRightService roleRightService;

    /**
     * 插入角色
     * @param role 角色
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String insert(Role role){
        try {
            //参数校验
            BioAssert.notNull(role, AuthorityErrorCode.ROLE_EMPTY_ERROR);

            //保存角色
            roleService.save(role);

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("添加角色信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 插入角色以及关联的权限
     * @param role 角色
     * @param roleRightList 角色权限
     * @return
     */
    @RequestMapping(value = "/insertRoleRight",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String insertRoleRight(Role role,List<RoleRight> roleRightList){
        try {
            //参数校验
            BioAssert.notNull(role, AuthorityErrorCode.ROLE_EMPTY_ERROR);
            BioAssert.notEmpty(roleRightList,AuthorityErrorCode.RIGHT_EMPTY_ERROR);

            //保存角色
            roleService.save(role);

            //保存角色拥有的权限
            for (RoleRight roleRight:roleRightList) {
                roleRight.setRoleId(role.getRoleId());
                roleRightService.save(roleRight);
            }

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("添加角色信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 修改角色
     * @param role 角色
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String update(Role role){
        try {
            //参数校验
            BioAssert.notNull(role, AuthorityErrorCode.ROLE_EMPTY_ERROR);

            //修改角色
            roleService.modifyById(role);

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("修改角色信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 修改角色以及关联的权限
     * @param role
     * @param roleRightList
     * @return
     */
    @RequestMapping(value = "/updateRoleRight",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String updateRoleRight(Role role,List<RoleRight> roleRightList){
        try {
            //参数校验
            BioAssert.notNull(role, AuthorityErrorCode.ROLE_EMPTY_ERROR);
            BioAssert.notEmpty(roleRightList,AuthorityErrorCode.RIGHT_EMPTY_ERROR);

            //修改角色
            roleService.modifyById(role);

            //修改角色对应的权限
            //1.删除原有的权限关联
            RoleRightQuery roleRightQuery = new RoleRightQuery();
            roleRightQuery.setRoleId(role.getRoleId());
            roleRightService.removeByQuery(roleRightQuery);
            //2.保存新的权限关联
            for (RoleRight roleRight:roleRightList) {
                roleRight.setRoleId(role.getRoleId());
                roleRightService.save(roleRight);
            }

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("修改角色信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 删除角色
     * @param roleId 角色ID
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String delete(String roleId){
        try {
            //参数校验
            BioAssert.notNull(roleId, AuthorityErrorCode.ROLE_EMPTY_ERROR);

            //删除角色
            roleService.removeById(roleId);

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("删除角色信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 删除角色以及关联的权限
     * @param roleId 角色ID
     * @return
     */
    @RequestMapping(value = "/deleteRoleRight",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String deleteRoleRight(String roleId){
        try {
            //参数校验
            BioAssert.notNull(roleId, AuthorityErrorCode.ROLE_EMPTY_ERROR);

            //删除角色
            roleService.removeById(roleId);

            //删除原有的权限关联
            RoleRightQuery roleRightQuery = new RoleRightQuery();
            roleRightQuery.setRoleId(roleId);
            roleRightService.removeByQuery(roleRightQuery);

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("删除角色信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 查询角色
     * @param roleQuery 角色
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String listRoles(RoleQuery roleQuery){
        try {
            //参数校验
            BioAssert.notNull(roleQuery, AuthorityErrorCode.ROLE_EMPTY_ERROR);

            //查询角色
            List<Role> list=roleService.queryList(roleQuery);

            return list.toString();
        } catch (Exception e) {
            logger.info("查询角色信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

}
