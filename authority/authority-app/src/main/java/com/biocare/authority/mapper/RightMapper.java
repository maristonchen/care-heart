package com.biocare.authority.mapper;

import com.biocare.authority.bean.Right;
import com.biocare.authority.query.RightQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 权限Mapper
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/22 11:37
 */
@Repository
@Meta(tableName = "t_right_info",keyProperty = "rightId")
public interface RightMapper extends BaseMapper<Right,RightQuery>{
}
