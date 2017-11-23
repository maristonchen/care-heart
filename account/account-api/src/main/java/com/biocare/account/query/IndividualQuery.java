package com.biocare.account.query;

import com.yhxd.tools.mybatis.query.BaseQuery;

/**
 * individual info querying instance
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/2 17:11
 */
public class IndividualQuery extends BaseQuery {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
