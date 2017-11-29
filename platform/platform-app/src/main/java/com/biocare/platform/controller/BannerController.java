package com.biocare.platform.controller;

import com.biocare.platform.bean.TemplateTable;
import com.biocare.platform.query.TemplateTablePageQuery;
import com.biocare.platform.service.BannerService;
import com.biocare.platform.service.TemplateTableService;
import com.yhxd.tools.web.result.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value="banner")
public class BannerController {

    Logger logger= LoggerFactory.getLogger(BannerController.class);

    @Autowired
    private BannerService bannerService;

    /**
     * 列表(带分页)
     * @return
     */
    @RequestMapping(value = "pageQuery",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult list(TemplateTablePageQuery pageQuery){
        JsonResult jsonResult = bannerService.queryDynamic();
        return jsonResult;
    }




}
