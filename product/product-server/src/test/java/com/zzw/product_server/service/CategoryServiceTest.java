package com.zzw.product_server.service;

import com.zzw.product_server.ProductServerApplicationTests;
import com.zzw.product_server.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/20 10:20
 */
@Component
public class CategoryServiceTest extends ProductServerApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(list.size() > 0);
    }
}