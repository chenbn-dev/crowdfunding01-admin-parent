package cn.chenbonian.crowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chbn
 * @create 2020-06-04 22:32
 */
// 启用feign客户端的功能
@EnableFeignClients
@EnableDiscoveryClient // 当前版本可以不写
@SpringBootApplication
public class AuthenticationConsumerMain4000 {
  public static void main(String[] args) {
    SpringApplication.run(AuthenticationConsumerMain4000.class, args);
  }
}
