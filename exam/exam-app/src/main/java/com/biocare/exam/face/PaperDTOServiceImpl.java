package com.biocare.exam.face;

import com.biocare.exam.api.PaperDTOService;
import com.biocare.exam.dto.PaperDTO;
import com.biocare.exam.query.PaperQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 16:09
 */
@Service("paperDTOService")
public class PaperDTOServiceImpl implements PaperDTOService {

    /**
     * query list of paper info
     *
     * @param paperQuery paper query
     * @return {@link List}
     */
    @Override
    public List<PaperDTO> queryList(PaperQuery paperQuery) {
        return null;
    }
}
