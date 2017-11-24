package com.biocare.authority.mapper;

import com.biocare.authority.bean.Group;
import com.biocare.authority.query.GroupQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 用户组Mapper
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/20 14:23
 */
@Repository
@Meta(tableName = "t_group_info",keyProperty = "groupId")
public interface GroupMapper extends BaseMapper<Group, GroupQuery> {
}
