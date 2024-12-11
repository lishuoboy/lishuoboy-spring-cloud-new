package top.lishuoboy.spring.cloud.gateway.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2024/12/11
 *
 * @author lishuoboy
 */
@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @GetMapping("/test")
    Object test() {
        return "test";
    }

}
