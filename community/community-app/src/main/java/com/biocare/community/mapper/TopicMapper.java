package com.biocare.community.mapper;

import com.biocare.account.bean.Individual;
import com.biocare.account.query.IndividualQuery;
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
public interface TopicMapper extends BaseMapper<Individual, IndividualQuery> {


}