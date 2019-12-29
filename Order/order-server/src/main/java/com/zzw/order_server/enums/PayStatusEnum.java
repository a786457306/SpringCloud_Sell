package com.zzw.order_server.enums;

import lombok.Getter;

/**
 * 支付状态枚举
 *
 * @author Daydreamer
 * @date 2019/12/20 15:18
 */

@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
