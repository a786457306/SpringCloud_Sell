package com.zzw.product.service;

import com.zzw.product.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Daydreamer
 * @date 2019/12/19 17:54
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    public void findUpstageAll() throws Exception {
        List<ProductInfo> list = service.findUpstageAll();
        assertTrue(list.size() > 0);
    }
}
