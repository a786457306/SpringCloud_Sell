package com.zzw.order_server.repository;

import com.zzw.order_server.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Daydreamer
 * @date 2019/12/20 15:18
 */

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}