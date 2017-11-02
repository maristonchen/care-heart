package com.biocare.authority.query;


import com.yhxd.tools.mybatis.query.BaseQuery;

/**
 * 模板查询实体
 *
 * @author mariston
 * @version V1.1.0
 * @since 2017/07/31
 */
public class TemplateQuery extends BaseQuery {

    /**
     * 姓名
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
