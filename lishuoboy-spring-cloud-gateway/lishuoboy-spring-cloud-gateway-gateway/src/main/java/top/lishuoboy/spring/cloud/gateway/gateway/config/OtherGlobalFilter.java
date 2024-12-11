package top.lishuoboy.spring.cloud.gateway.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/** 匹配上了yml的路由规则，Filter才会执行。比如：gateway自己的Controller，如果未匹配上，Filter不执行 */
@Order(20)  // 也可以通过实现Ordered接口控制顺序。默认值
@Slf4j
@Component
public class OtherGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.warn("测试执行顺序：GlobalFilter=={}", this.getClass().getName());
        return chain.filter(exchange);  //执行过滤链
    }
}
