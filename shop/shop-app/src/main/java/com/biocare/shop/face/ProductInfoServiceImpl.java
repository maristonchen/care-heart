package com.biocare.shop.face;

import com.biocare.shop.api.ProductInfoService;
import com.biocare.shop.dto.ProductInfo;
import com.biocare.shop.query.ProductQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/6 8:13
 */
@Service("productInfoService")
public class ProductInfoServiceImpl implements ProductInfoService {

    /**
     * query list of product info
     *
     * @param productQuery product query
     * @return {@link List} of product
     */
    @Override
    public List<ProductInfo> queryList(ProductQuery productQuery) {
        return null;
    }
}
