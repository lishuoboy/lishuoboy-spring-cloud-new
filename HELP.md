# 规范

## 模块命名规范

lishuoboy-spring-cloud-${对应starter的后缀名字}

## 模块划分(参考若依微服务版)

```text
root
├── ui              // 前端框架 [80/443]
├── gateway         // 网关模块 [8080]
│       └── gateway                             // 网关模块
├── auth            // 认证中心 [9200]
├── common          // 通用模块。为微服模块提供底层功能支持
│       └── common-core                         // 核心模块
│       └── common-datascope                    // 权限范围
│       └── common-datasource                   // 多数据源
│       └── common-log                          // 日志记录
│       └── common-redis                        // 缓存服务
│       └── common-seata                        // 分布式事务
│       └── common-security                     // 安全模块
│       └── common-swagger                      // 系统接口
├── biz         // 业务模块
│       └── biz1                // 业务模块1
│              └── biz1-api                     // 业务模块1-api，供其它业务模块feign调用的依赖。
│              └── biz1                         // 业务模块1 [8081]
│       └── biz2                // 业务模块2
│              └── biz2-api                     // 业务模块2-api，供其它业务模块feign调用的依赖。
│              └── biz2                         // 系统模块2 [8082]
├── middleware   // 中间件
│       └── register            // 注册中心
│              └── nacos                        // nacos
│              └── eureka                       // eureka
│       └── tx                  // 事务
│              └── nacos                        // nacos
│              └── eureka                       // eureka
├── visual          // 图形化管理模块
│       └── visual-monitor                      // 监控中心  [9100]
├──pom.xml                      // 公共依赖
```

## 模块端口

- 优先使用默认端口
- 业务模块808*，每加一个模块+1，第二个就是8082