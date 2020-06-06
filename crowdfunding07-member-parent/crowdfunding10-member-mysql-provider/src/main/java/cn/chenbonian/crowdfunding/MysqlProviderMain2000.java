package cn.chenbonian.crowdfunding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chbn
 * @create 2020-06-04 22:30
 */
@MapperScan("cn.chenbonian.crowdfunding.mapper")
@SpringBootApplication
public class MysqlProviderMain2000 {
  public static void main(String[] args) {
    SpringApplication.run(MysqlProviderMain2000.class, args);
  }
}
