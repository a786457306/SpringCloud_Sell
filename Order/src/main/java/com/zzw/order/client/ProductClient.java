package com.zzw.order.client;

import com.zzw.order.dataobject.ProductInfo;
import com.zzw.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 要调用的接口
 */

@FeignClient(name = "product")
public interface ProductClient {

    /**
     * 客户端访问服务端的地址
     * 声明要调用的远程方法，Feign作为http客户端，与调用本地方法非常相似
     *
     * @return
     */
    @GetMapping("/msg")
    String productMsg();

    /**
     * 根据订单获取商品列表
     * 使用RequestBody就必须用PostMapping
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/product/listProductForOrder")
    List<ProductInfo> listProductForOrder(@RequestBody List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
