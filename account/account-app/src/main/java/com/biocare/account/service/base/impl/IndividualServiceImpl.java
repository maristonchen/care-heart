package com.biocare.account.service.base.impl;

import com.biocare.account.bean.Individual;
import com.biocare.account.mapper.IndividualMapper;
import com.biocare.account.query.IndividualQuery;
import com.biocare.account.service.base.IndividualService;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 13:39
 */
@Service("individualService")
public class IndividualServiceImpl extends AbstractBaseService<Individual, IndividualQuery> implements IndividualService {

    /**
     * mapper
     */
    @Resource
    private IndividualMapper individualMapper;

    /**
     * 获取mapper方法
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<Individual, IndividualQuery> getMapper() {
        return this.individualMapper;
    }
}
