package top.lishuoboy.spring.cloud.biz.my.client.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Accessors(chain = true)
@ConfigurationProperties(prefix = "my.nacos")
public class MyClientNacosProp {
    Integer age = 18;
    String name;
}
