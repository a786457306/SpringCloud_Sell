package com.zzw.product_server.enums;

import lombok.Getter;

/**
 * @author Daydreamer
 * @date 2019/12/20 14:53
 */

@Getter
public enum ResultEnum {

    SUCCESS(0, "success"),
    PROUDCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存不足"),

    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
