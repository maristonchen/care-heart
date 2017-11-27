package com.biocare.plateform.controller;

import com.biocare.plateform.service.TemplateTableService;
import com.yhxd.tools.web.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
     * 新增
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public JsonResult add(String paramJson){
        System.out.println("request in");
        System.out.println(templateTableService);
        return new JsonResult(200,"新增成功");
    }


    /**
     * 根据主键删除（注意关联删除）
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public JsonResult delete(String id){
        System.out.println("request in");
        return new JsonResult(200,"删除成功");
    }



    /**
     * 根据主键更新
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public JsonResult update(String paramJson){
        System.out.println("request in");
        return new JsonResult(200,"更新成功");
    }


    /**
     * 列表(带分页)
     * @return
     */
    @RequestMapping(value = "list")
    @ResponseBody
    public JsonResult list(String paramJson){
        System.out.println("request in");
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