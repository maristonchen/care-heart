package com.biocare.platform.controller;

import com.biocare.platform.bean.TemplateTable;
import com.biocare.platform.query.TemplateTablePageQuery;
import com.biocare.platform.service.TemplateTableService;
import com.yhxd.tools.base.date.DateFormatUtil;
import com.yhxd.tools.web.result.JsonResult;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;


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
        templateTable.setTemplateId(UUID.randomUUID().toString().replace("-",""));
        templateTableService.saveSelective(templateTable);
        return new JsonResult(200,"新增成功");
    }


    /**
     * 根据主键删除（注意关联删除）
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(String templateId){
        templateTableService.removeById(templateId);
        return new JsonResult(200,"删除成功");
    }



    /**
     * 根据主键更新
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(TemplateTable templateTable){
        templateTableService.modifyById(templateTable);
        return new JsonResult(200,"更新成功");
    }


    /**
     * 列表(带分页)
     * @return
     */
    @RequestMapping(value = "pageQuery",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list(TemplateTablePageQuery pageQuery){
        JsonResult jsonResult = templateTableService.queryDynamic(pageQuery);
        return jsonResult;
    }


    /**
     * 下载Excel导入模板
     * @return
     */
    @RequestMapping(value = "downloadExcelTemplate",method = RequestMethod.GET)
    @ResponseBody
    public void downloadExcelTemplate(HttpServletResponse resp) throws IOException {

        XSSFWorkbook book = templateTableService.downloadExcelTemplate();
        resp = handleRespHeader(resp, "模板表导入模板");
        ServletOutputStream outputStream = resp.getOutputStream();
        book.write(outputStream);
        outputStream.close();
    }


    /**
     * 导入Excel
     * @return
     */
    @RequestMapping(value = "importExcel",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult importExcel(MultipartFile excelFile) throws Exception {
        InputStream inputStream = excelFile.getInputStream();
        return templateTableService.importExcel(excelFile);
    }


    /**
     * 导出为Excel
     * @return
     */
    @RequestMapping(value = "exportExcel",method = RequestMethod.GET)
    @ResponseBody
    public void exportExcel(TemplateTablePageQuery pageQuery, HttpServletResponse resp) throws IOException {
        XSSFWorkbook book = templateTableService.exportExcel(pageQuery);
        resp=handleRespHeader(resp,"模板表");
        ServletOutputStream outputStream = resp.getOutputStream();
        book.write(outputStream);
        outputStream.close();
    }

    /**
     * 处理返回excel文件时的响应头
     * @param resp
     * @param fileName
     * @return
     */
    private HttpServletResponse handleRespHeader(HttpServletResponse resp,String fileName) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.addHeader("Content-type", " application/octet-stream");
        String fileNameAlias = new String((fileName).getBytes(), "ISO8859_1");
        resp.addHeader("Content-Disposition",
                new StringBuffer().append("attachment;filename=").append(fileNameAlias+ DateFormatUtil.dateTimeLong(new Date())+".xlsx").toString());
        return resp;

    }

}
