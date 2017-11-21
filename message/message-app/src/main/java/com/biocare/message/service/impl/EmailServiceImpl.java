package com.biocare.message.service.impl;

import com.biocare.message.bean.Email;
import com.biocare.message.mapper.EmailMapper;
import com.biocare.message.query.EmailQuery;
import com.biocare.message.service.EmailService;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/6 18:02
 */
@Service("emailService")
public class EmailServiceImpl extends AbstractBaseService<Email, EmailQuery> implements EmailService {

    /**
     * email mapper
     */
    @Resource
    private EmailMapper emailMapper;

    /**
     * 获取mapper方法
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<Email, EmailQuery> getMapper() {
        return this.emailMapper;
    }
}
