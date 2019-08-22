package com.springzhou.gatewayservice.GatewayLimiter.Config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author zhou
 * @create 2019-08-20 17:26
 * @description: 用户维度限流配置
 */
//@Configuration
public class UserkeyResolverConfig {

    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }
}