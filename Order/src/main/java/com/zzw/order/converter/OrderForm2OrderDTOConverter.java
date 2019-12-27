package com.zzw.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zzw.order.dataobject.OrderDetail;
import com.zzw.order.dto.OrderDTO;
import com.zzw.order.enums.ResultEnum;
import com.zzw.order.exception.OrderException;
import com.zzw.order.form.OrderForm;
import com.zzw.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/20 16:26
 */

@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convertFormToDTO(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetails = new ArrayList<>();

        Gson gson = new Gson();
        try {
            orderDetails = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("[json转换]错误， string = {}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetails(orderDetails);

        return orderDTO;
    }
}
