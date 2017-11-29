package com.biocare.platform.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 模板-实体
 * @author Renhao
 * @version 1.0
 */
public class TemplateTable implements Serializable{

    private static final long serialVersionUID = -8893494706131531685L;

    //id
    private String templateId;
    //String字段
    private String templateString;
    //整数字段
    private int templateInt;
    //小数字段
    private Double templateDouble;
    //时间字段
    private Date templateDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateString() {
        return templateString;
    }

    public void setTemplateString(String templateString) {
        this.templateString = templateString;
    }

    public int getTemplateInt() {
        return templateInt;
    }

    public void setTemplateInt(int templateInt) {
        this.templateInt = templateInt;
    }

    public Double getTemplateDouble() {
        return templateDouble;
    }

    public void setTemplateDouble(Double templateDouble) {
        this.templateDouble = templateDouble;
    }

    public Date getTemplateDate() {
        return templateDate;
    }

    public void setTemplateDate(Date templateDate) {
        this.templateDate = templateDate;
    }
}
