package com.moetez.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }
   /* @Bean
    public RouteLocator MyRouteConfig(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/api/types/**")
                        .uri("lb://TYPE-MICROSERVICE"))
                .route(p -> p
                        .path("/api/clients/**")
                        .uri("lb://Client"))
                .build();
    }*/
}
