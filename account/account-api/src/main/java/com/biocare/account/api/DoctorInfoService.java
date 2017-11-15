package com.biocare.account.api;

import com.biocare.account.dto.DoctorInfo;
import com.biocare.account.query.DoctorQuery;

import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/8 12:45
 */
public interface DoctorInfoService {

    /**
     * query one doctor info by query condition
     *
     * @param doctorQuery query condition
     * @return {@link DoctorInfo}
     */
    DoctorInfo queryOne(DoctorQuery doctorQuery);

    /**
     * query list of doctor info by query condition
     *
     * @param doctorQuery query condition
     * @return {@link List} of doctor info
     */
    List<DoctorInfo> queryList(DoctorQuery doctorQuery);
}
