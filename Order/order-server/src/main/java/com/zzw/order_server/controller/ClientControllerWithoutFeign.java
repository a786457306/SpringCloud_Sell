package com.zzw.order_server.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/withoutFeign")
public class ClientControllerWithoutFeign {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // 第一种方式：写死url
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);

        // 第二种方式：使用LoadBalancerClient，通过应用名获取地址
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance product = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s", product.getHost(), product.getPort() + "/msg");
        String response = restTemplate.getForObject(url, String.class);

        // 第三种方式：注入RestTemplate，使用注解进行负载均衡，可以直接写应用名字
//        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        log.info("response:{}", response);

        return response;
    }
}
