package top.lishuoboy.spring.cloud.biz.my.server.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Accessors(chain = true)
public class Cat {
    /** 唯一id */
    private Integer id;
    /** 名字 */
    private String name;
}
