package com.zzw.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Daydreamer
 * @date 2019/12/27 16:40
 */

@Data
@AllArgsConstructor
public class CartDTO {

    /**
     * 商品Id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;
}
