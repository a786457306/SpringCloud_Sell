package com.zzw.product_common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 服务调用方传入的减库存对象
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecreaseStockForService {

    /**
     * 商品Id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;
}
