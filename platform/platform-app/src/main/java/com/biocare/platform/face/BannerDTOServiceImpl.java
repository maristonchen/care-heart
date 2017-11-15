package com.biocare.platform.face;

import com.biocare.platform.api.BannerDTOService;
import com.biocare.platform.dto.BannerDTO;
import com.biocare.platform.query.BannerQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 17:39
 */
@Service("bannerDTOService")
public class BannerDTOServiceImpl implements BannerDTOService {

    /**
     * query list of banner info
     *
     * @param bannerQuery banner query
     * @return {@link List} of banner info
     */
    @Override
    public List<BannerDTO> queryList(BannerQuery bannerQuery) {
        return null;
    }
}
