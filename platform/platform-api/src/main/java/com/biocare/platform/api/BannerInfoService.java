package com.biocare.platform.api;

import com.biocare.platform.dto.BannerInfo;
import com.biocare.platform.query.BannerQuery;

import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 17:30
 */
public interface BannerInfoService {

    /**
     * query list of banner info
     *
     * @param bannerQuery banner query
     * @return {@link List} of banner info
     */
    List<BannerInfo> queryList(BannerQuery bannerQuery);
}
