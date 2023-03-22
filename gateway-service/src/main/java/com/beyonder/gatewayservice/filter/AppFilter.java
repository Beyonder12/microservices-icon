package com.beyonder.gatewayservice.filter;

import com.beyonder.gatewayservice.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.*;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppFilter implements GatewayFilter {
    private final RestTemplate restTemplate;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request =  exchange.getRequest();
        final List<String> apiEndpoints = List.of("/api/v1/auth/register", "/api/v1/auth/login");

        Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
                .noneMatch(uri -> r.getURI().getPath().contains(uri));
        if (isApiSecured.test(request)) {
            if (!request.getHeaders().containsKey("Authorization")) {
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }
            final String token = request.getHeaders().getOrEmpty("Authorization").get(0);
            String newToken = token.split(" ")[1];
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(newToken);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<UserDTO> response;
//            response = restTemplate.exchange("http://localhost:8085/api/v1/auth/user-data-2", HttpMethod.GET, entity, UserDTO.class);
            response = restTemplate.exchange("http://auth-service:8085/api/v1/auth/user-data-2", HttpMethod.GET, entity, UserDTO.class);

            exchange.getRequest().mutate().header("role", String.valueOf(Objects.requireNonNull(response.getBody()).getRole())).build();
            exchange.getRequest().mutate().header("id", String.valueOf(response.getBody().getId())).build();
        }
        return chain.filter(exchange);
    }
}
