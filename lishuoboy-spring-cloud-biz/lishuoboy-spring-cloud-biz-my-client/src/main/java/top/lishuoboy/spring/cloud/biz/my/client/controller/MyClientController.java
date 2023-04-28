package top.lishuoboy.spring.cloud.biz.my.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lishuoboy.spring.cloud.biz.my.server.api.entity.Cat;

@Slf4j
@RestController
@RequestMapping("/myClient")
public class MyClientController {
    /** http://localhost:8081/myClient/restTemplateTest */
    @GetMapping("/restTemplateTest")
    private Object restTemplateTest() {
        log.warn("我是 myClient");
        Cat cat = Cat.builder().name("汤姆猫").build();
        log.warn("cat=={}", cat);
        return cat;
    }
}
