package com.biocare.platform.query;

import java.util.Date;

/**
 * 模板-分页查询参数
 * @author Renhao
 * @version 1.0
 */
public class TemplateTablePageQuery {
    Integer page;
    Integer pageSize;

    String templateString;

    //模板-时间-起始
    Date templateDateMin;
    //模板-时间-结束
    Date templateDateMax;

    Integer templateInt;



    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTemplateString() {
        return templateString;
    }

    public void setTemplateString(String templateString) {
        this.templateString = templateString;
    }

    public Date getTemplateDateMin() {
        return templateDateMin;
    }

    public void setTemplateDateMin(Date templateDateMin) {
        this.templateDateMin = templateDateMin;
    }

    public Date getTemplateDateMax() {
        return templateDateMax;
    }

    public void setTemplateDateMax(Date templateDateMax) {
        this.templateDateMax = templateDateMax;
    }

    public Integer getTemplateInt() {
        return templateInt;
    }

    public void setTemplateInt(Integer templateInt) {
        this.templateInt = templateInt;
    }
}
