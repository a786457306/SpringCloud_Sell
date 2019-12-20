package com.zzw.order.exception;

import com.zzw.order.enums.ResultEnum;

/**
 * @author Daydreamer
 * @date 2019/12/20 16:19
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
