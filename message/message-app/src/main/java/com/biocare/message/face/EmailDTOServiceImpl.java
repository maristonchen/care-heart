package com.biocare.message.face;

import com.biocare.message.api.EmailDTOService;
import com.biocare.message.dto.EmailDTO;
import com.biocare.message.query.EmailQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/6 17:57
 */
@Service("emailDTOService")
public class EmailDTOServiceImpl implements EmailDTOService {

    /**
     * query list of email info
     *
     * @param emailQuery email query
     * @return {@link List} of email info
     */
    @Override
    public List<EmailDTO> queryList(EmailQuery emailQuery) {
        return null;
    }
}
