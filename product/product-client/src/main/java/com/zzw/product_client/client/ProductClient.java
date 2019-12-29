package com.zzw.product_client.client;

import com.zzw.product_common.DecreaseStockForService;
import com.zzw.product_common.ProductInfoForClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 对外提供的接口
 */

@FeignClient(name = "product")
public interface ProductClient {

    /**
     * 根据订单获取商品列表
     * 使用RequestBody就必须用PostMapping
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/product/listProductForOrder")
    List<ProductInfoForClient> listProductForOrder(@RequestBody List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockList
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockForService> decreaseStockList);
}
