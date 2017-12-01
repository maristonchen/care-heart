package com.biocare.authority.mapper;

import com.biocare.authority.bean.GroupRight;
import com.biocare.authority.query.GroupRightQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.enumtype.GenerationType;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 用户组权限Mapper
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/11/30 14:51
 */
@Repository
@Meta(tableName = "t_group_right_info",keyProperty = "grId",keyStrategy = GenerationType.CUSTOM )
public interface GroupRightMapper extends BaseMapper<GroupRight,GroupRightQuery>{
}
