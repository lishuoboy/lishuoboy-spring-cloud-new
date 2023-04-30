package top.lishuoboy.spring.cloud.biz.my.server.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.lishuoboy.spring.cloud.biz.my.server.api.dict.ServiceInfoMyServer;
import top.lishuoboy.spring.cloud.biz.my.server.api.entity.Cat;

@Service
@FeignClient(value = ServiceInfoMyServer.NAME, path = "/myServer")  // 大小写敏感
public interface MyServerApi {
    @GetMapping("/openFeignTest")
    Cat openFeignTest(@RequestParam String name);
}