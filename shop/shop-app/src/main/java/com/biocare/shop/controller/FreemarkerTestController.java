package com.biocare.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 集成Freemarker测试
 * 在页面以/web/freemarker/test进行访问
 * 测试通过
 */
@Controller
@RequestMapping(value="freemarker")
public class FreemarkerTestController {

    /**
     * freemarker测试页面
     * 模板在WEBB-INF/ftl/test.ftl
     * @param mv 视图
     * @return
     */
    @RequestMapping(value = "test")
    public ModelAndView test(ModelAndView mv){
        System.out.println("request in");
        mv.addObject("name","jack");
        mv.setViewName("test");
        return mv;
    }
}
