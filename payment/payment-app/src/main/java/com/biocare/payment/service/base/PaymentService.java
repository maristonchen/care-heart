package com.biocare.payment.service.base;

import com.biocare.payment.bean.Payment;
import com.biocare.payment.query.PaymentQuery;
import com.yhxd.tools.mybatis.service.BaseService;

/**
 * payment order base service interface
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/7 11:42
 */
public interface PaymentService extends BaseService<Payment, PaymentQuery> {
}
