package com.biocare.message.api;

import com.biocare.message.dto.EmailDTO;
import com.biocare.message.query.EmailQuery;

import java.util.List;

/**
 * e-mail API
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/6 17:11
 */
public interface EmailDTOService {

    /**
     * query list of email info
     *
     * @param emailQuery email query
     * @return {@link List} of email info
     */
    List<EmailDTO> queryList(EmailQuery emailQuery);
}
