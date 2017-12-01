package com.biocare.authority.controller;

import com.alibaba.fastjson.JSON;
import com.biocare.authority.bean.Login;
import com.biocare.authority.bean.LoginRole;
import com.biocare.authority.dto.TreeMenuDTO;
import com.biocare.authority.em.AuthorityErrorCode;
import com.biocare.authority.handler.MenuHandler;
import com.biocare.authority.query.LoginQuery;
import com.biocare.authority.query.LoginRoleQuery;
import com.biocare.authority.service.LoginService;
import com.biocare.authority.service.LoginRoleService;
import com.biocare.common.exception.BioException;
import com.biocare.common.utils.BioAssert;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

/**
 * 登录用户控制器
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 16:35
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登录用户业务接口
     */
    @Resource
    private LoginService loginService;

    /**
     * 用户角色业务接口
     */
    @Resource
    private LoginRoleService loginRoleService;

    /**
     * 菜单业务Handler
     */
    @Resource
    private MenuHandler menuHandler;

    /**
     * 插入登录用户
     * @param login 登录用户
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String insert(Login login){
        try {
            //参数校验
            BioAssert.notNull(login, AuthorityErrorCode.USER_EMPTY_ERROR);

            //保存用户
            loginService.save(login);

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("添加登录用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 插入登录用户以及关联的角色
     * @param login 登录用户
     * @param loginRoleList 登录用户角色
     * @return
     */
    @RequestMapping(value = "/insertUserRole",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String insertUserRole(Login login,List<LoginRole> loginRoleList){
        try {
            //参数校验
            BioAssert.notNull(login, AuthorityErrorCode.USER_EMPTY_ERROR);
            BioAssert.notEmpty(loginRoleList,AuthorityErrorCode.ROLE_EMPTY_ERROR);

            //保存登录用户
            loginService.save(login);

            //保存登录用户拥有的角色
            for (LoginRole loginRole:loginRoleList) {
                loginRole.setUrId(login.getUserId());
                loginRoleService.save(loginRole);
            }

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("添加登录用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 修改登录用户
     * @param login 登录用户
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String update(Login login){
        try {
            //参数校验
            BioAssert.notNull(login, AuthorityErrorCode.USER_EMPTY_ERROR);

            //修改登录用户
            loginService.modifyById(login);

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("修改登录用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 修改登录用户以及关联的角色
     * @param login
     * @param loginRoleList
     * @return
     */
    @RequestMapping(value = "/updateUserRole",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String updateUserRole(Login login,List<LoginRole> loginRoleList){
        try {
            //参数校验
            BioAssert.notNull(login, AuthorityErrorCode.USER_EMPTY_ERROR);
            BioAssert.notEmpty(loginRoleList,AuthorityErrorCode.ROLE_EMPTY_ERROR);

            //修改登录角色
            loginService.modifyById(login);

            //修改用户对应的角色
            //1.删除原有的角色关联
            LoginRoleQuery loginRoleQuery=new LoginRoleQuery();
            loginRoleQuery.setUserId(login.getUserId());
            loginRoleService.removeByQuery(loginRoleQuery);
            //2.保存新的角色关联
            for (LoginRole loginRole:loginRoleList) {
                loginRole.setUrId(login.getUserId());
                loginRoleService.save(loginRole);
            }

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("修改登录用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 删除登录用户
     * @param userId 登录用户ID
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String delete(String userId){
        try {
            //参数校验
            BioAssert.notNull(userId, AuthorityErrorCode.USER_EMPTY_ERROR);

            //删除用户
            loginService.removeById(userId);

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("删除用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 删除登录用户以及关联的角色
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/deleteUserRole",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String deleteUserRole(String userId){
        try {
            //参数校验
            BioAssert.notNull(userId, AuthorityErrorCode.USER_EMPTY_ERROR);

            //删除用户
            loginService.removeById(userId);

            //删除原有的角色关联
            LoginRoleQuery loginRoleQuery = new LoginRoleQuery();
            loginRoleQuery.setUserId(userId);
            loginRoleService.removeByQuery(loginRoleQuery);

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("删除用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 查询登录用户
     * @param loginQuery 登录用户
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String list(LoginQuery loginQuery){
        try {
            //参数校验
            BioAssert.notNull(loginQuery, AuthorityErrorCode.USER_EMPTY_ERROR);

            //查询登录用户
            List<Login> list = loginService.queryList(loginQuery);

            return list.toString();
        } catch (Exception e) {
            logger.info("查询登录用户信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 获取手机验证码
     * @param phoneNo 手机号码
     * @return
     */
    @RequestMapping(value = "/getMobileVerificationCode",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String getMobileVerificationCode(String phoneNo){
        try {
            //参数校验
            BioAssert.hasText(phoneNo,AuthorityErrorCode.PHONENO_EMPTY_ERROR);

            //验证码
            String verificationCode = RandomStringUtils.randomNumeric(6);

            //发送验证码短信

            return verificationCode;
        } catch (Exception e) {
            logger.info("获取手机验证码异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 登录
     * @param login
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String login(Login login){
        try {
            //参数校验
            BioAssert.notNull(login,AuthorityErrorCode.LOGIN_EMPTY_ERROR);

            //校验登录信息
            LoginQuery loginQuery = new LoginQuery();
            loginQuery.setUsername(login.getUsername());
            List<Login> list=loginService.queryList(loginQuery);

            if(!CollectionUtils.isEmpty(list)&&StringUtils.equals(login.getPassword(),list.get(0).getPassword())){
                return AuthorityErrorCode.LOGIN_SUCCESS.toString();
            }else{
                return AuthorityErrorCode.USERNAME_PASSWORD_ERROR.toString();
            }
        } catch (Exception e) {
            logger.info("登录异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 获取树形菜单
     * @param username 用户名
     * @return
     */
    @RequestMapping(value = "/getTreeMenu",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String getTreeMenu(String username){
        try {
            //参数校验
            BioAssert.hasText(username,AuthorityErrorCode.NAME_EMPTY_ERROR);

            //获取树形菜单
            List<TreeMenuDTO> treeMenu=menuHandler.getTreeMenu(username);

            return JSON.toJSONString(treeMenu);
        } catch (Exception e) {
            logger.info("获取树形菜单异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

}
