package com.biocare.shop.mapper;

import com.biocare.shop.bean.Product;
import com.biocare.shop.query.ProductQuery;
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
@Meta(tableName = "template", keyProperty = "id")
public interface ProductMapper extends BaseMapper<Product, ProductQuery> {


}