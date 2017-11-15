package com.biocare.account.api;

import com.biocare.account.dto.IndividualInfo;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/2 16:20
 */
public interface IndividualInfoService {

    /**
     * query  Individual info by  his phone
     *
     * @param phone phone num
     * @return {@link IndividualInfo}
     */
    IndividualInfo query(String phone);
}
