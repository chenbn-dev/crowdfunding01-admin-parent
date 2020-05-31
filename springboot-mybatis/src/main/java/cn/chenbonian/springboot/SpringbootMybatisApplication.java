package cn.chenbonian.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.chenbonian.springboot.mapper")
@SpringBootApplication
public class SpringbootMybatisApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootMybatisApplication.class, args);
  }
}
