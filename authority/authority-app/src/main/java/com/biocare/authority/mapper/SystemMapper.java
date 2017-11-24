package com.biocare.authority.mapper;

import com.biocare.authority.bean.System;
import com.biocare.authority.query.SystemQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 子系统Mapper
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 14:01
 */
@Repository
@Meta(tableName = "t_system_info",keyProperty = "sysId")
public interface SystemMapper extends BaseMapper<System,SystemQuery>{
}
