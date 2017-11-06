package com.biocare.message.mapper;

import com.biocare.message.bean.Email;
import com.biocare.message.query.EmailQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * email mapper file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/6 17:58
 */
@Repository
@Meta(tableName = "t_email_info",keyProperty = "emailId")
public interface EmailMapper extends BaseMapper<Email,EmailQuery> {

}
