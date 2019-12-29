package com.zzw.order_server.controller;

import com.zzw.order_server.converter.OrderForm2OrderDTOConverter;
import com.zzw.order_server.dto.OrderDTO;
import com.zzw.order_server.enums.ResultEnum;
import com.zzw.order_server.exception.OrderException;
import com.zzw.order_server.form.OrderForm;
import com.zzw.order_server.service.OrderService;
import com.zzw.order_server.utils.ResultVOUtil;
import com.zzw.order_server.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Daydreamer
 * @date 2019/12/20 15:15
 */

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单入库步骤：
     * 1. 参数校验
     * 2. 查询商品信息（调用商品服务）
     * 3. 计算总价
     * 4. 扣库存（调用商品服务）
     * 5. 订单入库
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("[创建订单] 参数不正确，orderForm = {}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        // orderForm to orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convertFormToDTO(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {
            log.error("[创建订单]购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.createOrder(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }
}
