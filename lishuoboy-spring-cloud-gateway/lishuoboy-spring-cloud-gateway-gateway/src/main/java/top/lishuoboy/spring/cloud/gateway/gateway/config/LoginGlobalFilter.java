package top.lishuoboy.spring.cloud.gateway.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(10)  // 也可以通过实现Ordered接口控制顺序
@Slf4j
@Component
public class LoginGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.warn("测试执行顺序：GlobalFilter=={}", this.getClass().getName());
        String token = exchange.getRequest().getHeaders().getFirst("x-user-token");

        // 业务逻辑 start
        log.warn("token=={}", token);
        // 业务逻辑 end

        return chain.filter(exchange);  //执行过滤链
    }

}
