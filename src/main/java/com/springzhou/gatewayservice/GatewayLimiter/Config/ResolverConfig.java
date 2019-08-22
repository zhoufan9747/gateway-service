package com.springzhou.gatewayservice.GatewayLimiter.Config;

import com.springzhou.gatewayservice.GatewayLimiter.HostAddrKeyResolver;
import com.springzhou.gatewayservice.GatewayLimiter.UriKeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author zhou
 * @create 2019-08-20 17:21
 * @description:
 */
@Configuration
public class ResolverConfig {
    public ResolverConfig(){
        System.out.println("初始化各种限流拦截器。。。");
    }

    //根据Hostname进行限流
    @Bean(value = "hostAddrKeyResolver")
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

    //@Bean(value = "remoteAddKeyResolver")
    public KeyResolver remoteAddKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

    //uri限流
    //@Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }

}