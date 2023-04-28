package top.lishuoboy.spring.cloud.biz.my.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lishuoboy
 * @date 2022/4/24
 */
@Configuration
public class RestTemplateConfig {
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}