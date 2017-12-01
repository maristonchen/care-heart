package com.biocare.account.mapper;

import com.biocare.account.bean.Institution;
import com.biocare.account.query.InstitutionQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.enumtype.GenerationType;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 机构Mapper
 *
 * @author Quintic
 * @version 1.0
 * @since 2017/12/1 18:26
 */
@Repository
@Meta(tableName = "t_institution_info",keyProperty ="institutionId",keyStrategy = GenerationType.CUSTOM)
public interface InstitutionMapper extends BaseMapper<Institution,InstitutionQuery>{
}
