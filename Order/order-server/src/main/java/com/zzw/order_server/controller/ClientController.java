//package com.zzw.order_server.controller;
//
//import com.zzw.product_client.client.ProductClient;
//import com.zzw.order_server.dataobject.ProductInfo;
//import com.zzw.order_server.dto.CartDTO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@Slf4j
//public class ClientController {
//
//    @Autowired
//    private ProductClient productClient;
//
//    @GetMapping("/getProductList")
//    public String getProductList() {
//        List<ProductInfo> productInfoList = productClient.listProductForOrder();
//        log.info("response={}", productInfoList);
//        return "ok";
//    }
//
//    @PostMapping
//    public String productDecreaseStock() {
//        productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022", 2)));
//        return "ok";
//    }
//}
