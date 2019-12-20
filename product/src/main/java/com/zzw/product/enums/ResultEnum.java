package com.zzw.product.enums;

import lombok.Getter;

/**
 * @author Daydreamer
 * @date 2019/12/20 14:53
 */

@Getter
public enum ResultEnum {

    SUCCESS(0, "success");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
