package com.beyonder.gatewayservice.config;

import com.beyonder.gatewayservice.filter.AdminFilter;
import com.beyonder.gatewayservice.filter.AppFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfiguration {
    private final AppFilter filter;
    private final AdminFilter adminFilter;

    private final String endPoint8081 = "http://localhost:8081/";
    @Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/v1/lessons/**")
                        .and().method("POST", "PUT", "DELETE")
                        .filters(f -> f.filter(filter).filter(adminFilter))
                        .uri(endPoint8081))
                .route(r -> r.path("/api/v1/lessons/**")
                        .and().method("GET")
                        .filters(f -> f.filter(filter))
                        .uri(endPoint8081))
                .route(r -> r.path("/api/v1/userLessons/**")
                        .and().method("GET")
                        .filters(f -> f.filter(filter))
                        .uri(endPoint8081))
                .route(r -> r.path("/api/v1/jobs/**")
                        .and().method("POST", "PUT", "DELETE")
                        .filters(f -> f.filter(filter).filter(adminFilter))
                        .uri("http://localhost:8082/"))
                .route(r -> r.path("/api/v1/jobs/**")
                        .and().method("GET")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8082/"))
                .route(r -> r.path("/api/v1/userJobs/**")
                        .and().method("GET")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8082/"))
                .route(r -> r.path("/api/v1/lesson_reviews/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8083/"))
                .route(r -> r.path("/api/v1/users/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8084/"))
                .route(r -> r.path("/api/v1/userCerts/**")
                        .and().method("GET")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8084/"))
                .route(r -> r.path("/api/v1/auth/all-users")
                        .filters(f -> f.filter(filter).filter(adminFilter))
                        .uri("http://auth-service:8085/"))
                .route(r -> r.path("/api/v1/auth/**")
                        .uri("http://auth-service:8085/"))
                .build();
    }
}
