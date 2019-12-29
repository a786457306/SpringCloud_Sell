package com.zzw.order_server.repository;

import com.zzw.order_server.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Daydreamer
 * @date 2019/12/20 15:19
 */

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
