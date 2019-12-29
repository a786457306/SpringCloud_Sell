package com.zzw.product_server.repository;

import com.zzw.product_server.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 实体对象，Id类型
 *
 * @author Daydreamer
 * @date 2019/12/19 16:56
 */

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
