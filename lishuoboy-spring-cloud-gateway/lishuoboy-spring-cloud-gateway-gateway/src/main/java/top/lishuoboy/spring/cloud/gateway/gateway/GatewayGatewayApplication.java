package top.lishuoboy.spring.cloud.gateway.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.lishuoboy.dependency.sb.sb.MySbUtil;

@SpringBootApplication
public class GatewayGatewayApplication {

    public static void main(String[] args) {
        MySbUtil.run(GatewayGatewayApplication.class, args);
    }

}
