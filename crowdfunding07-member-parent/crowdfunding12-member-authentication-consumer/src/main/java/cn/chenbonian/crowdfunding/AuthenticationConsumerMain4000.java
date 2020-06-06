package cn.chenbonian.crowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chbn
 * @create 2020-06-04 22:32
 */
@EnableDiscoveryClient // 当前版本可以不写
@SpringBootApplication
public class AuthenticationConsumerMain4000 {
  public static void main(String[] args) {
    SpringApplication.run(AuthenticationConsumerMain4000.class, args);
  }
}
