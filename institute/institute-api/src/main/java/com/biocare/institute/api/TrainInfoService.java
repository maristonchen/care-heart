package com.biocare.institute.api;

import com.biocare.institute.dto.TrainInfo;
import com.biocare.institute.query.TrainQuery;

import java.util.List;

/**
 * train info interface api
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/15 16:19
 */
public interface TrainInfoService {

    /**
     * query list of  train info
     *
     * @param trainQuery train query
     * @return {@link List}
     */
    List<TrainInfo> queryList(TrainQuery trainQuery);
}
