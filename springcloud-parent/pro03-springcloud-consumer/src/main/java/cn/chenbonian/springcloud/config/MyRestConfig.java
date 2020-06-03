package cn.chenbonian.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chbn
 * @create 2020-06-02 8:15
 */
@Configuration
public class MyRestConfig {
  @Bean
  @LoadBalanced
  public RestTemplate getRestTempate() {
    return new RestTemplate();
  }
}
