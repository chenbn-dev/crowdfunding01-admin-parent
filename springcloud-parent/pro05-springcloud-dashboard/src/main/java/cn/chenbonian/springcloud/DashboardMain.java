package cn.chenbonian.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author chbn
 * @create 2020-06-03 23:01
 */
// 启用 Hystrix 仪表盘功能
@EnableHystrixDashboard
@SpringBootApplication
public class DashboardMain {
  public static void main(String[] args) {
    SpringApplication.run(DashboardMain.class, args);
  }
}
