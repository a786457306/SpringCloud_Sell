package com.zzw.order_server.service;

import com.zzw.order_server.dto.OrderDTO;

/**
 * @author Daydreamer
 * @date 2019/12/20 15:26
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO createOrder(OrderDTO orderDTO);
}
