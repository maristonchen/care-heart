package com.biocare.institute.mapper;

import com.biocare.institute.bean.Video;
import com.biocare.institute.query.VideoQuery;
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
public interface VideoMapper extends BaseMapper<Video, VideoQuery> {


}