package com.zzw.product_server.repository;

import com.zzw.product_server.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 实体对象，Id类型
 *
 * @author Daydreamer
 * @date 2019/12/19 16:56
 */

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
