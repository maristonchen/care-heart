package com.biocare.platform.service.base.impl;

import com.biocare.platform.bean.Banner;
import com.biocare.platform.query.BannerQuery;
import com.biocare.platform.service.base.BannerService;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 17:38
 */
public class BannerServiceImpl extends AbstractBaseService<Banner, BannerQuery> implements BannerService {

    /**
     * 获取mapper方法
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<Banner, BannerQuery> getMapper() {
        return null;
    }
}
