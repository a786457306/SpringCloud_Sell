package com.zzw.product.service.impl;

import com.zzw.product.dataobject.ProductInfo;
import com.zzw.product.enums.ProductStatusEnum;
import com.zzw.product.repository.ProductInfoRepository;
import com.zzw.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/19 17:33
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    /**
     * 查询所有在架商品
     *
     * @return
     */
    @Override
    public List<ProductInfo> findUpstageAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
