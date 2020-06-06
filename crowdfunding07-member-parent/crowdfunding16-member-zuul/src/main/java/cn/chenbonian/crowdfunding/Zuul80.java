package cn.chenbonian.crowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author chbn
 * @create 2020-06-06 11:19
 */
@EnableZuulProxy
@SpringBootApplication
public class Zuul80 {
  public static void main(String[] args) {
    SpringApplication.run(Zuul80.class, args);
  }
}
