package com.biocare.shop.service.impl;

import com.biocare.shop.bean.Product;
import com.biocare.shop.query.ProductQuery;
import com.biocare.shop.service.ProductService;
import com.yhxd.tools.mybatis.mapper.BaseMapper;
import com.yhxd.tools.mybatis.service.AbstractBaseService;
import org.springframework.stereotype.Service;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/6 8:11
 */
@Service("productService")
public class ProductServiceImpl extends AbstractBaseService<Product, ProductQuery> implements ProductService {


    /**
     * 获取mapper方法
     *
     * @return {@link BaseMapper}
     */
    @Override
    protected BaseMapper<Product, ProductQuery> getMapper() {
        return null;
    }
}
