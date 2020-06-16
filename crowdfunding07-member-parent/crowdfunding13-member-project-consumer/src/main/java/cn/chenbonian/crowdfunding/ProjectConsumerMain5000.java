package cn.chenbonian.crowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chbn
 * @create 2020-06-04 22:32
 */
// 启用Feign客户端功能
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ProjectConsumerMain5000 {
  public static void main(String[] args) {
    SpringApplication.run(ProjectConsumerMain5000.class, args);
  }
}
