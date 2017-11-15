package com.biocare.shop.api;

import com.biocare.shop.dto.ProductDTO;
import com.biocare.shop.query.ProductQuery;

import java.util.List;

/**
 * please descripe this java file
 *
 * @author mariston
 * @version 1.0
 * @since 2017/11/6 8:13
 */
public interface ProductDTOService {

    /**
     * query list of product info
     *
     * @param productQuery product query
     * @return {@link List} of product
     */
    List<ProductDTO> queryList(ProductQuery productQuery);
}
