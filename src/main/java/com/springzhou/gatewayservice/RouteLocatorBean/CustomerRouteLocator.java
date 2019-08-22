package com.springzhou.gatewayservice.RouteLocatorBean;

import com.springzhou.gatewayservice.Filter.RequestTimeFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhou
 * @create 2019-08-20 15:24
 * @description: 自定义路由拦截
 */
//@Configuration
public class CustomerRouteLocator {

    public CustomerRouteLocator() {
        System.out.println("CustomerRouteLocator自定义路由拦截容器启动初始化。。。");
    }

    @Bean
    public RouteLocator requestTimeFilter(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(r -> r.path("/demo/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addRequestHeader("X-Request-Foo","zhou")
                                .addResponseHeader("X-Response-Default-Foo", "fan").stripPrefix(1))
                        .uri("lb://EXAMPLE")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
        // @formatter:on
    }

}