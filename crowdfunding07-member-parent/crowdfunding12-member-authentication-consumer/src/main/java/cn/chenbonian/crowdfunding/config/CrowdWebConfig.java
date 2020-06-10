package cn.chenbonian.crowdfunding.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chbn
 * @create 2020-06-07 12:45
 */
@Configuration
public class CrowdWebConfig implements WebMvcConfigurer {
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    // 浏览器访问地址
    String urlPath = "/auth/member/to/reg/page";
    // 目标视图的名称，将来拼接前后缀
    String viewName = "member-reg";
    registry.addViewController(urlPath).setViewName(viewName);
    registry.addViewController("/auth/member/to/login/page").setViewName("member-login");
    registry.addViewController("/auth/member/to/center/page").setViewName("member-center");
  }
}
