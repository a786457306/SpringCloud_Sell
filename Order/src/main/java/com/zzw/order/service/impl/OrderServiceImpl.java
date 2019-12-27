package com.zzw.order.service.impl;

import com.zzw.order.dataobject.OrderMaster;
import com.zzw.order.dto.OrderDTO;
import com.zzw.order.enums.OrderStatusEnum;
import com.zzw.order.enums.PayStatusEnum;
import com.zzw.order.repository.OrderDetailRepository;
import com.zzw.order.repository.OrderMasterRepository;
import com.zzw.order.service.OrderService;
import com.zzw.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Daydreamer
 * @date 2019/12/20 15:29
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    /**
     * 订单入库步骤：
     * 1. 参数校验
     * 2. todo:查询商品信息（调用商品服务）
     * 3. todo:计算总价
     * 4. todo:扣库存（调用商品服务）
     * 5. 订单入库
     */
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

        // 查询商品信息（调用商品服务）


        // 订单入库
        OrderMaster orderMaster = new OrderMaster();

        orderDTO.setOrderId(KeyUtil.uniqueKeyGenerator());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
