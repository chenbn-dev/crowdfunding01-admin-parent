package cn.chenbonian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author chbn
 * @create 2020-06-02 0:02
 */
// 下面两个注解，功能大致相同，
// @EnableDiscoveryClient // 启动发现服务的功能，不局限与Eureka注册中心
// @EnableEurekaClient // 启用Eureka客户端功能，必须是Eureka注册中心，高版本SpringClud可以省略
// 使用@EnableCircuitBreaker注解开启断路器功能
@EnableCircuitBreaker
@SpringBootApplication
public class ProviderMain {
  public static void main(String[] args) {
    SpringApplication.run(ProviderMain.class, args);
  }
}
