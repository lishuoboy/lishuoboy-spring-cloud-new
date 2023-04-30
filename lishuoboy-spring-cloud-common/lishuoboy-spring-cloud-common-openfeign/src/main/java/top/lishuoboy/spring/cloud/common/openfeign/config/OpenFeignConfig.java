package top.lishuoboy.spring.cloud.common.openfeign.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"top.lishuoboy.spring.cloud"})
public class OpenFeignConfig {
}