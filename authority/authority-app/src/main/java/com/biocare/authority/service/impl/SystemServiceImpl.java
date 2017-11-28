package com.biocare.authority.service.impl;

import com.biocare.authority.bean.System;
import com.biocare.authority.mapper.SystemMapper;
import com.biocare.authority.query.SystemQuery;
import com.biocare.authority.service.SystemService;
import com.biocare.common.utils.UniqueNoUtil;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 子系统业务接口实现类
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 14:57
 */
@Service("systemService")
public class SystemServiceImpl extends AbstractBaseService<System,SystemQuery> implements SystemService{

    /**
     * 子系统Mapper
     */
    @Resource
    private SystemMapper systemMapper;

    /**
     * 获取子系统Mapper
     * @return
     */
    @Override
    protected BaseMapper<System, SystemQuery> getMapper() {
        return this.systemMapper;
    }

    /**
     * 重写插入方法，设置自定义主键
     * @param system 子系统
     */
    @Override
    public void save(System system) {
        system.setSysId(UniqueNoUtil.genNumber(UniqueNoUtil.T_SYSTEM_INTO));
        super.save(system);
    }
}
