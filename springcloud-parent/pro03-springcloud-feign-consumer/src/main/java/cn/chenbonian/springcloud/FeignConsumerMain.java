package cn.chenbonian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chbn
 * @create 2020-06-02 0:02
 */
// 启用Feign客户端的功能
@EnableFeignClients
@SpringBootApplication
public class FeignConsumerMain {
  public static void main(String[] args) {
    SpringApplication.run(FeignConsumerMain.class, args);
  }
}
