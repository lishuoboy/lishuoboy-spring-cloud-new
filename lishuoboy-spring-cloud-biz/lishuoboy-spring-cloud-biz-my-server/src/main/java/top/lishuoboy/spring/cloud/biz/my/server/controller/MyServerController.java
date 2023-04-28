package top.lishuoboy.spring.cloud.biz.my.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lishuoboy.spring.cloud.biz.my.server.api.entity.Cat;

@Slf4j
@RestController
@RequestMapping("/myServer")
public class MyServerController {
    @Value("${server.port}")
    int serverPort;

    /** http://localhost:8082/myServer/restTemplateTest?name=tomcat */
    @RequestMapping("/restTemplateTest")
    private Cat restTemplateTest(String name) {
        log.warn("你好，{}，我是 myServer", name);
        return Cat.builder().id(serverPort).name(name).build();
    }
}
