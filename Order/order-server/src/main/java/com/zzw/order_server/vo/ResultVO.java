package com.zzw.order_server.vo;

import lombok.Data;

/**
 * 封装http请求返回对象
 *
 * @author Daydreamer
 * @date 2019/12/20 10:24
 */

@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
