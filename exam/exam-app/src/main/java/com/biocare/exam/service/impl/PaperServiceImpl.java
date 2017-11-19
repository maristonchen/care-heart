package com.biocare.exam.service.impl;

import com.biocare.exam.bean.Paper;
import com.biocare.exam.query.PaperQuery;
import com.biocare.exam.service.PaperService;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 16:07
 */
public class PaperServiceImpl extends AbstractBaseService<Paper, PaperQuery> implements PaperService {

    /**
     * 获取mapper方法
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<Paper, PaperQuery> getMapper() {
        return null;
    }
}
