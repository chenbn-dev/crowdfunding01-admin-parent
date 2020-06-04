package cn.chenbonian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author chbn
 * @create 2020-06-03 23:40
 */
// 启用zuul代理的功能
@EnableZuulProxy
@SpringBootApplication
public class ZuulMain {
  public static void main(String[] args) {
    SpringApplication.run(ZuulMain.class, args);
  }
}
