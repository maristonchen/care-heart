package com.biocare.authority.controller;

import com.biocare.authority.bean.Right;
import com.biocare.authority.em.AuthorityErrorCode;
import com.biocare.authority.query.RightQuery;
import com.biocare.authority.service.RightService;
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
 * 权限控制器
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/23 9:47
 */
@Controller
@RequestMapping("right")
public class RightController {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(RightController.class);

    /**
     * 权限业务接口
     */
    @Resource
    private RightService rightService;

    /**
     * 插入权限
     * @param right 权限
     * @return
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String insert(Right right){
        try {
            //参数校验
            BioAssert.notNull(right, AuthorityErrorCode.RIGHT_EMPTY_ERROR);

            //保存权限
            rightService.save(right);

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("添加权限信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 修改权限
     * @param right 权限
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String update(Right right){
        try {
            //参数校验
            BioAssert.notNull(right, AuthorityErrorCode.RIGHT_EMPTY_ERROR);

            //保存权限
            rightService.modifyById(right);

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("修改权限信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 删除权限
     * @param rightId 权限ID
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String delete(String rightId){
        try {
            //参数校验
            BioAssert.notNull(rightId, AuthorityErrorCode.RIGHT_EMPTY_ERROR);

            //保存权限
            rightService.removeById(rightId);

            return AuthorityErrorCode.SUCCESS.toString();
        } catch (Exception e) {
            logger.info("删除权限信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }

    /**
     * 查询权限
     * @param rightQuery 权限ID
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String listRoles(RightQuery rightQuery){
        try {
            //参数校验
            BioAssert.notNull(rightQuery, AuthorityErrorCode.RIGHT_EMPTY_ERROR);

            //保存权限
            List<Right> list=rightService.queryList(rightQuery);

            return list.toString();
        } catch (Exception e) {
            logger.info("查询权限信息异常：[{}]:{}", e.getStackTrace()[0], e.getMessage());
            if(e instanceof BioException){
                throw e;
            }else{
                throw new BioException(AuthorityErrorCode.FAIL);
            }
        }
    }
}
