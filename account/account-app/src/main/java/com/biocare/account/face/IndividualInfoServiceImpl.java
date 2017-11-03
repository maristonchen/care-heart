package com.biocare.account.face;

import com.biocare.account.api.IndividualInfoService;
import com.biocare.account.bean.Individual;
import org.springframework.stereotype.Service;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 13:35
 */
@Service("individualInfoService")
public class IndividualInfoServiceImpl implements IndividualInfoService {

    /**
     * query  Individual info by  his phone
     *
     * @param phone phone num
     * @return
     */
    @Override
    public Individual query(String phone) {
        return null;
    }
}
