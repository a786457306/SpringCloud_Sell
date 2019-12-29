package com.zzw.product_server.service;

import com.zzw.product_server.dataobject.ProductCategory;

import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/20 10:15
 */
public interface CategoryService {

    /**
     * 根据类目查询商品
     *
     * @param categoryList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList);
}
