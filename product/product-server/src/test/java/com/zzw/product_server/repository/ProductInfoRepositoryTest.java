package com.zzw.product_server.repository;

import com.zzw.product_server.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Daydreamer
 * @date 2019/12/19 17:05
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findProductInfoByStatus() {
        List<ProductInfo> productInfos = repository.findByProductStatus(0);
        assertTrue(productInfos.size() > 0);
    }

    @Test
    public void findProductListForOrder() {
//        repository.findByProductIdIn(Arrays.asList())
    }
}
