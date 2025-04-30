package top.lishuoboy.spring.cloud.biz.my.server.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.lishuoboy.spring.cloud.biz.my.server.api.dict.ServiceInfoMyServer;
import top.lishuoboy.spring.cloud.biz.my.server.api.entity.Cat;

@Service
/// 【注意】contextId 用于配置 注入spring 的 beanName，防止beanName重复报错。
/// 当配置多个 “@FeignClient(value = ServiceInfoMyServer.NAME” 且未指定contextId时，
/// 会报错“The bean 'myServerApi.FeignClientSpecification' could not be registered. A bean with that name has already been defined and overriding is disabled.”。
@FeignClient(value = ServiceInfoMyServer.NAME, path = "/myServer", contextId = "myServerApi")  // 大小写敏感
public interface MyServerApi {
    @GetMapping("/openFeignTest")
    Cat openFeignTest(@RequestParam String name);
}