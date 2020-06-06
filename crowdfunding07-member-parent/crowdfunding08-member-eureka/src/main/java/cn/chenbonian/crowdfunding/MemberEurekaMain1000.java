package cn.chenbonian.crowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author chbn
 * @create 2020-06-04 22:29
 */
@EnableEurekaServer
@SpringBootApplication
public class MemberEurekaMain1000 {
  public static void main(String[] args) {
    SpringApplication.run(MemberEurekaMain1000.class, args);
  }
}
