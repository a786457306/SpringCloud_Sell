package com.zzw.product.repository;

import com.zzw.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 实体对象，Id类型
 *
 * @author Daydreamer
 * @date 2019/12/19 16:56
 */

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
