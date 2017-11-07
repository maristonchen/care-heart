package com.biocare.payment.mapper;

import com.biocare.payment.bean.Payment;
import com.biocare.payment.query.PaymentQuery;
import com.yhxd.tools.mybatis.annotations.Meta;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 模板MAPPER
 *
 * @author mariston
 * @since 2017/08/14
 */
@Repository
@Meta(tableName = "t_payment_info", keyProperty = "id")
public interface PaymentMapper extends BaseMapper<Payment, PaymentQuery> {


}