package com.biocare.exam.mapper;

import com.biocare.exam.bean.Paper;
import com.biocare.exam.query.PaperQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/3 15:59
 */
@Repository
@Meta(tableName = "template", keyProperty = "id")
public interface PaperMapper extends BaseMapper<Paper,PaperQuery>{

}
