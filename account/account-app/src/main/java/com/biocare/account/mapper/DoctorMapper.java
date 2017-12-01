package com.biocare.account.mapper;

import com.biocare.account.bean.Doctor;
import com.biocare.account.query.DoctorQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.enumtype.GenerationType;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 医生Mapper
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/12/1 18:21
 */
@Repository
@Meta(tableName = "t_doctor_info",keyProperty ="doctorId",keyStrategy = GenerationType.CUSTOM)
public interface DoctorMapper extends BaseMapper<Doctor,DoctorQuery>{
}
