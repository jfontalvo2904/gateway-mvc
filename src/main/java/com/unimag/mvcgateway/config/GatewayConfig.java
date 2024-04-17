package com.unimag.mvcgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;



@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("jsonplaceholder", route -> route
                .path("/placeholder/todos/**")
                .filters(f -> f.rewritePath("/placeholder/", "/"))
                .uri("https://jsonplaceholder.typicode.com"))

            .route("pokeapi", route -> route
                .path("/api/v2/**")
                .uri("https://pokeapi.co"))

            .route("httpbin", route -> route
                .path("/get")
                .uri("http://httpbin.org:80"))
            .build();
    }
}