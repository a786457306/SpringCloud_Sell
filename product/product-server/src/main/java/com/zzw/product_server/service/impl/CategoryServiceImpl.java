package com.zzw.product_server.service.impl;

import com.zzw.product_server.dataobject.ProductCategory;
import com.zzw.product_server.repository.ProductCategoryRepository;
import com.zzw.product_server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/20 10:17
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList) {
        return categoryRepository.findByCategoryTypeIn(categoryList);
    }
}
