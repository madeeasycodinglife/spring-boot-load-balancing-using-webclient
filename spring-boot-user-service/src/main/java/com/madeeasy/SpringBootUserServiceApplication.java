package com.madeeasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUserServiceApplication.class, args);
    }

    /**
     * Load balance with  WebClient .
     * you have to write bleow two method i.e. #1. builder() #2. webClient(WebClient.Builder builder)
     */
    @Bean
    @LoadBalanced
    public WebClient.Builder builder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }
}
