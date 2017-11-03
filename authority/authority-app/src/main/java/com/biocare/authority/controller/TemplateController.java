package com.biocare.authority.controller;

import com.alibaba.fastjson.JSON;
import com.biocare.authority.bean.Template;
import com.biocare.authority.service.base.TemplateService;
import com.yhxd.tools.web.page.DTPage;
import com.yhxd.tools.web.result.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 示例控制中心
 *
 * @author mariston
 * @version V1.1.0
 * @since 2017/07/27
 */
@Controller
@RequestMapping("/example")
public class TemplateController {

    /**
     * 业务接口
     */
    @Resource
    private TemplateService templateService;


    /**
     * 转向显示页面
     *
     * @return
     */
    @RequestMapping("listPage")
    public ModelAndView page(ModelAndView mv) {
        mv.setViewName("main/generator/template/listPage");
        return mv;
    }

    /**
     * 新增(Selective)
     *
     * @param request
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insert(HttpServletRequest request, String jsonParam) {
        templateService.saveSelective(JSON.parseObject(jsonParam, Template.class));
        return new JsonResult(200, "写入成功");
    }

    /**
     * 删除(根据主键)
     *
     * @param request
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(HttpServletRequest request, String jsonParam) {
        templateService.removeById(JSON.parseObject(jsonParam, Template.class).getId());
        return new JsonResult(200, "删除成功");
    }

    /**
     * 更新(根据主键)
     *
     * @param request
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request, String jsonParam) {
        return new JsonResult(200, "更新成功");
    }

    /**
     * 分页查询列表
     *
     * @param page 分页对象
     * @return string
     */
    @RequestMapping(value = "/queryByPage", produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String queryByPage(DTPage<Template> page) {
        //分页查询
        templateService.queryByPage(page);

        return page.toString();
    }
}
