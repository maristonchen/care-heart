package com.biocare.exam.api;

import com.biocare.exam.dto.PaperInfo;
import com.biocare.exam.query.PaperQuery;

import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 15:47
 */
public interface PaperInfoService {


    /**
     * query list of paper info
     *
     * @param paperQuery paper query
     * @return {@link List}
     */
    List<PaperInfo> queryList(PaperQuery paperQuery);
}
