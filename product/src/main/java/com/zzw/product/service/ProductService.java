package com.zzw.product.service;

import com.zzw.product.dataobject.ProductInfo;
import org.springframework.stereotype.Service;

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

    /**
     * 根据订单信息查询商品列表
     *
     * @param productIdList
     * @return
     */
    List<ProductInfo> findProductListForOrder(List<String> productIdList);
}
