package cn.chenbonian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author chbn
 * @create 2020-06-02 8:39
 */
// 启用Eureka服务器端功能
@EnableEurekaServer
@SpringBootApplication
public class MyEurekaServer {
  public static void main(String[] args) {
    SpringApplication.run(MyEurekaServer.class, args);
  }
}
