package top.lishuoboy.spring.cloud.biz.my.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.lishuoboy.spring.cloud.biz.my.server.api.entity.Cat;

@Slf4j
@RestController
@RequestMapping("/myClient")
public class MyClientController {
    @Autowired
    private RestTemplate restTemplate;

    /** http://localhost:8081/myClient/restTemplateTest */
    @GetMapping("/restTemplateTest")
    private Object restTemplateTest() {
        log.warn("我是 myClient");
        Cat cat = restTemplate.getForObject("http://127.0.0.1:8082" + "/myServer/restTemplateTest?name=加菲猫", Cat.class);
        log.warn("cat=={}", cat);
        return cat;
    }
}
