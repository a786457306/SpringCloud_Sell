package com.zzw.order_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Daydreamer
 * @date 2019/12/27 16:40
 */

@Data
@AllArgsConstructor
// 没有无参构造方法，序列化会失败。加了前两个注解，就没有默认的无参构造方法了。
@NoArgsConstructor
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
