package com.biocare.payment.service.base.impl;

import com.biocare.payment.bean.Payment;
import com.biocare.payment.mapper.PaymentMapper;
import com.biocare.payment.query.PaymentQuery;
import com.biocare.payment.service.base.PaymentService;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/7 11:43
 */
@Service("paymentService")
public class PaymentServiceImpl extends AbstractBaseService<Payment, PaymentQuery> implements PaymentService {

    /**
     * payment mapper
     */
    @Resource
    private PaymentMapper paymentMapper;

    /**
     * 获取mapper方法
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<Payment, PaymentQuery> getMapper() {
        return this.paymentMapper;
    }

}
