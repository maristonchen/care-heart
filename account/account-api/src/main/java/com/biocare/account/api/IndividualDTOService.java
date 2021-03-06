package com.biocare.account.api;

import com.biocare.common.bean.RequestWrapper;
import com.biocare.common.bean.ResponseWrapper;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/2 16:20
 */
public interface IndividualDTOService {

    /**
     * query  Individual info by  his phone
     *
     * @param request  request
     * @return {@link ResponseWrapper}
     */
    ResponseWrapper queryOneByCondition(RequestWrapper request);
}
