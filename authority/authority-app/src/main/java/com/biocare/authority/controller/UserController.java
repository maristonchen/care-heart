package com.biocare.authority.controller;

import com.biocare.authority.bean.User;
import com.biocare.authority.bean.UserRole;
import com.biocare.authority.query.UserQuery;
import com.biocare.authority.query.UserRoleQuery;
import com.biocare.authority.service.UserRoleService;
import com.biocare.authority.service.UserService;
import com.biocare.common.em.GlobalErrorCode;
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
 * 用户控制器
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 16:35
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 用户业务接口
     */
    @Resource
    private UserService userService;

    /**
     * 用户角色业务接口
     */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 插入用户
     * @param user 用户
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String insert(User user){
        try {
            //参数校验
            BioAssert.notNull(user, GlobalErrorCode.USER_EMPTY_ERROR);

            //保存用户
            userService.save(user);

            return GlobalErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("添加用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(GlobalErrorCode.FAIL);
            }
        }
    }

    /**
     * 插入用户以及关联的角色
     * @param user 用户
     * @param userRoleList 用户角色
     * @return
     */
    @RequestMapping(value = "/insertUserRole",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String insertUserRole(User user,List<UserRole> userRoleList){
        try {
            //参数校验
            BioAssert.notNull(user, GlobalErrorCode.USER_EMPTY_ERROR);
            BioAssert.notEmpty(userRoleList,GlobalErrorCode.ROLE_EMPTY_ERROR);

            //保存用户
            userService.save(user);

            //保存用户拥有的角色
            for (UserRole userRole:userRoleList) {
                userRole.setUrId(user.getUserId());
                userRoleService.save(userRole);
            }

            return GlobalErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("添加用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(GlobalErrorCode.FAIL);
            }
        }
    }

    /**
     * 修改用户
     * @param user 用户
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String update(User user){
        try {
            //参数校验
            BioAssert.notNull(user, GlobalErrorCode.USER_EMPTY_ERROR);

            //修改角色
            userService.modifyById(user);

            return GlobalErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("修改用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(GlobalErrorCode.FAIL);
            }
        }
    }

    /**
     * 修改用户以及关联的角色
     * @param user
     * @param userRoleList
     * @return
     */
    @RequestMapping(value = "/updateUserRole",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String updateUserRole(User user,List<UserRole> userRoleList){
        try {
            //参数校验
            BioAssert.notNull(user, GlobalErrorCode.USER_EMPTY_ERROR);
            BioAssert.notEmpty(userRoleList,GlobalErrorCode.ROLE_EMPTY_ERROR);

            //修改角色
            userService.modifyById(user);

            //修改用户对应的角色
            //1.删除原有的角色关联
            UserRoleQuery userRoleQuery=new UserRoleQuery();
            userRoleQuery.setUserId(user.getUserId());
            userRoleService.removeByQuery(userRoleQuery);
            //2.保存新的角色关联
            for (UserRole userRole:userRoleList) {
                userRole.setUrId(user.getUserId());
                userRoleService.save(userRole);
            }

            return GlobalErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("修改用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(GlobalErrorCode.FAIL);
            }
        }
    }

    /**
     * 删除用户
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String delete(String userId){
        try {
            //参数校验
            BioAssert.notNull(userId, GlobalErrorCode.USER_EMPTY_ERROR);

            //删除用户
            userService.removeById(userId);

            return GlobalErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("删除用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(GlobalErrorCode.FAIL);
            }
        }
    }

    /**
     * 删除用户以及关联的角色
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/deleteUserRole",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String deleteUserRole(String userId){
        try {
            //参数校验
            BioAssert.notNull(userId, GlobalErrorCode.OBJECT_PARAM_NULL);

            //删除用户
            userService.removeById(userId);

            //删除原有的角色关联
            UserRoleQuery userRoleQuery = new UserRoleQuery();
            userRoleQuery.setUserId(userId);
            userRoleService.removeByQuery(userRoleQuery);

            return GlobalErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("删除用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(GlobalErrorCode.FAIL);
            }
        }
    }

    /**
     * 查询用户
     * @param userQuery 用户
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String listRoles(UserQuery userQuery){
        try {
            //参数校验
            BioAssert.notNull(userQuery, GlobalErrorCode.USER_EMPTY_ERROR);

            //查询用户
            List<User> list = userService.queryList(userQuery);

            return list.toString();
        } catch (Exception e) {
            logger.info("查询用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(GlobalErrorCode.FAIL);
            }
        }
    }
}
