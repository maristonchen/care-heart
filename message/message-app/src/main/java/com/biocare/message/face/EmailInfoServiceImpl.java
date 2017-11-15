package com.biocare.message.face;

import com.biocare.message.api.EmailInfoService;
import com.biocare.message.dto.EmailInfo;
import com.biocare.message.query.EmailQuery;

import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/6 17:57
 */
public class EmailInfoServiceImpl implements EmailInfoService {

    /**
     * query list of email info
     *
     * @param emailQuery email query
     * @return {@link List} of email info
     */
    @Override
    public List<EmailInfo> queryList(EmailQuery emailQuery) {
        return null;
    }
}
