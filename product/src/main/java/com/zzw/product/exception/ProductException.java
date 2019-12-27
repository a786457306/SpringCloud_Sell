package com.zzw.product.exception;


import com.zzw.product.enums.ResultEnum;

/**
 * @author Daydreamer
 * @date 2019/12/20 16:19
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
