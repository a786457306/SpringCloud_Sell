package com.zzw.product.service;

import com.zzw.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/19 17:31
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpstageAll();
}
