package com.biocare.platform.service;

import com.biocare.platform.bean.Banner;
import com.biocare.platform.query.BannerQuery;
import com.yhxd.tools.mybatis.service.BaseService;
import com.yhxd.tools.web.result.JsonResult;

/**
 *  the banner service interface
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 17:37
 */
public interface BannerService extends BaseService<Banner, BannerQuery> {
    JsonResult queryDynamic();
}
