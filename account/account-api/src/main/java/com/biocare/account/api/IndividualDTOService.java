package com.biocare.account.api;

import com.biocare.account.dto.IndividualDTO;

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
     * @param phone phone num
     * @return {@link IndividualDTO}
     */
    IndividualDTO query(String phone);
}
