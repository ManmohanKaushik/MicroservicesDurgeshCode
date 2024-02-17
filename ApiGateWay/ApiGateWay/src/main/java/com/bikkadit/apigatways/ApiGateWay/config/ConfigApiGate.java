package com.bikkadit.apigatways.ApiGateWay.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApiGate {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder.routes()

                .route(p -> p.path("/apiU/**")
                        .uri("lb://USER-SERVICES"))
                .route(p -> p.path("/apiH/**")
                        .uri("lb://HOTEL-SERVICE"))
                .route(p -> p.path("/apiR/**")
                        .uri("lb://RATING-SERVICE")).build();

    }
}
