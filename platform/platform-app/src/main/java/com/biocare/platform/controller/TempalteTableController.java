package com.biocare.platform.controller;

import com.biocare.common.utils.UniqueNoUtil;
import com.biocare.platform.bean.TemplateTable;
import com.biocare.platform.query.TemplateTablePageQuery;
import com.biocare.platform.service.TemplateTableService;
import com.yhxd.tools.web.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 模板-控制器
 * @author Renhao
 * @version 1.0
 */
@Controller
@RequestMapping(value="templateTable")
public class TempalteTableController {

    Logger logger= LoggerFactory.getLogger(TempalteTableController.class);

    @Autowired
    private TemplateTableService templateTableService;

    /**
     * 新增(Selective)
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add(TemplateTable templateTable,HttpServletRequest request){
        System.out.println(request.getParameter("templateString"));
        templateTableService.saveSelective(templateTable);
        return new JsonResult(200,"新增成功");
    }


    /**
     * 根据主键删除（注意关联删除）
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public JsonResult delete(String id){
        templateTableService.removeById(id);
        return new JsonResult(200,"删除成功");
    }



    /**
     * 根据主键更新
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public JsonResult update(TemplateTable templateTable){
        templateTableService.modifyById(templateTable);
        return new JsonResult(200,"更新成功");
    }


    /**
     * 列表(带分页)
     * @return
     */
    @RequestMapping(value = "pageQuery")
    @ResponseBody
    public JsonResult list(TemplateTablePageQuery pageQuery){
        templateTableService.queryDynamic(pageQuery);
        return new JsonResult(200,"分页查询成功","[我是数据]",1000);
    }


    /**
     * 下载Excel导入模板
     * @return
     */
    @RequestMapping(value = "downloadExcelTempate")
    @ResponseBody
    public JsonResult downloadExcelTempate(){
        System.out.println("request in");
        return new JsonResult(200,"Excel导入模板下载成功");
    }


    /**
     * 导入Excel
     * @return
     */
    @RequestMapping(value = "importExcel")
    @ResponseBody
    public JsonResult importExcel(String paramJson){
        System.out.println("request in");
        return new JsonResult(200,"Excel导入成功");
    }


    /**
     * 导出为Excel
     * @return
     */
    @RequestMapping(value = "exportExcel")
    @ResponseBody
    public JsonResult exportExcel(String paramJson){
        System.out.println("request in");
        //实质是返回一个文件
        return new JsonResult(200,"Excel导出成功");
    }



}
