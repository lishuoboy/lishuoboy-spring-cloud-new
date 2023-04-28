package top.lishuoboy.spring.cloud.biz.my.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.lishuoboy.dependency.sb.sb.MySbUtil;

@SpringBootApplication
public class MyClientApplication {

    public static void main(String[] args) {
        MySbUtil.run(MyClientApplication.class, args);
    }

}
