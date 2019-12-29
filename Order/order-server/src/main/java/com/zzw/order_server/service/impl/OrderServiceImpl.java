package com.zzw.order_server.service.impl;

import com.zzw.product_client.client.ProductClient;
import com.zzw.order_server.dataobject.OrderDetail;
import com.zzw.order_server.dataobject.OrderMaster;
import com.zzw.order_server.dataobject.ProductInfo;
import com.zzw.order_server.dto.CartDTO;
import com.zzw.order_server.dto.OrderDTO;
import com.zzw.order_server.enums.OrderStatusEnum;
import com.zzw.order_server.enums.PayStatusEnum;
import com.zzw.order_server.repository.OrderDetailRepository;
import com.zzw.order_server.repository.OrderMasterRepository;
import com.zzw.order_server.service.OrderService;
import com.zzw.order_server.utils.KeyUtil;
import com.zzw.product_common.DecreaseStockForService;
import com.zzw.product_common.ProductInfoForClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private ProductClient productClient;

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

        String orderId = KeyUtil.uniqueKeyGenerator();

        // 查询商品信息（调用商品服务）
        List<String> productIdList =  orderDTO.getOrderDetails().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoForClient> productInfoList = productClient.listProductForOrder(productIdList);

        // 计算商品总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetails()) {
            for (ProductInfoForClient productInfo : productInfoList) {
                if (orderDetail.getProductId() == productInfo.getProductId()) {
                    orderAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.uniqueKeyGenerator());

                    // 订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        // 扣库存
        List<DecreaseStockForService> decreaseStockList = orderDTO.getOrderDetails().stream()
                .map(e -> new DecreaseStockForService(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockList);

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();

        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
