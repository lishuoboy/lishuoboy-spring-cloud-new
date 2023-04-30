package top.lishuoboy.spring.cloud.biz.my.client.controller;

import cn.hutool.core.util.RandomUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.lishuoboy.dependency.sb.json.JacksonUtil;
import top.lishuoboy.spring.cloud.biz.my.server.api.entity.Cat;
import top.lishuoboy.spring.cloud.biz.my.server.api.service.MyServerApi;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/myClient")
public class MyClientController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private MyServerApi myServerApi;

    /** http://localhost:8081/myClient/restTemplateTest */
    @GetMapping({"/restTemplateTest", "/openFeignTest"})
    private Object restTemplateTest() {
        log.warn("我是 myClient");
//        Cat cat = restTemplate.getForObject("http://127.0.0.1:8082" + "/myServer/restTemplateTest?name=加菲猫", Cat.class);                          // 写死url
//        Cat cat = restTemplate.getForObject(getServiceAddr(ServiceInfoMyServer.NAME) + "/myServer/restTemplateTest?name=加菲猫", Cat.class);         // 写活url，手写负载均衡策略
//        Cat cat = restTemplate.getForObject("http://" + ServiceInfoMyServer.NAME + "/myServer/restTemplateTest?name=加菲猫", Cat.class);             // loadbalancer，自动负载均衡，默认轮询
        Cat cat = myServerApi.openFeignTest("加菲猫");                                                                                           // openFeign，面向接口，自动负载均衡策略，默认轮询
        log.warn("cat=={}", cat);
        return cat;
    }

    @SneakyThrows
    private String getServiceAddr(String serverName) {
        List<String> services = discoveryClient.getServices();
        log.warn("services=={}", services);
        List<ServiceInstance> instances = discoveryClient.getInstances(serverName);
        log.warn("instances=={}", JacksonUtil.toStr(instances));
        int index = RandomUtil.randomInt(instances.size());    // 模拟负载均衡策略：随机取一个
        URI uri = instances.get(index).getUri();
        log.warn("uri=={}", uri.toString());
        return uri.toString();
    }
}
