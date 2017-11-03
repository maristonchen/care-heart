package com.biocare.community.mapper;

import com.biocare.community.bean.Topic;
import com.biocare.community.query.TopicQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 模板MAPPER
 *
 * @author mariston
 * @since 2017/08/14
 */
@Repository
@Meta(tableName = "template", keyProperty = "id")
public interface TopicMapper extends BaseMapper<Topic, TopicQuery> {


}