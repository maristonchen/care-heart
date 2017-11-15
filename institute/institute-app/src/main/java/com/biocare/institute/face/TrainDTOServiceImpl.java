package com.biocare.institute.face;

import com.biocare.institute.api.TrainDTOService;
import com.biocare.institute.dto.TrainDTO;
import com.biocare.institute.query.TrainQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/15 16:21
 */
@Service("trainDTOService")
public class TrainDTOServiceImpl implements TrainDTOService {

    /**
     * query list of  train info
     *
     * @param trainQuery train query
     * @return {@link List}
     */
    @Override
    public List<TrainDTO> queryList(TrainQuery trainQuery) {
        return null;
    }
}
