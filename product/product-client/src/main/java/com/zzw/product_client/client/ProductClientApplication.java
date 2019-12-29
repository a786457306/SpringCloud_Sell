package com.zzw.product_client.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductClientApplication.class, args);
    }

}
