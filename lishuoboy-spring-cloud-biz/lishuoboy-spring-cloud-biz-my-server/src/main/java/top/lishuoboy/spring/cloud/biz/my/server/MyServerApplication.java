package top.lishuoboy.spring.cloud.biz.my.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.lishuoboy.dependency.sb.sb.MySbUtil;

@SpringBootApplication
public class MyServerApplication {

    public static void main(String[] args) {
        MySbUtil.run(MyServerApplication.class, args);
    }

}
