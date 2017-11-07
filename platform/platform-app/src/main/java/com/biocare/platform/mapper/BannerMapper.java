package com.biocare.platform.mapper;

import com.biocare.platform.bean.Banner;
import com.biocare.platform.query.BannerQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 模板MAPPER
 *
 * @author mariston
 * @version 1.0
 * @since 2017/08/14
 */
@Repository
@Meta(tableName = "t_banner_info", keyProperty = "id")
public interface BannerMapper extends BaseMapper<Banner, BannerQuery> {


}