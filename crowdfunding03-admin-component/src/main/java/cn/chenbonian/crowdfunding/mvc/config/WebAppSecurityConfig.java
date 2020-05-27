package cn.chenbonian.crowdfunding.mvc.config;

import cn.chenbonian.crowdfunding.constant.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chbn
 * @create 2020-05-23 9:26
 */
// 表示当前类是一个配置类
@Configuration
// 启动web环境下权限控制功能
@EnableWebSecurity
// 启用全局方法权限控制功能，并且设置prePostEnabled = true。保证 @PreAuthority、@PostAuthority、@PreFiletr、@PostFilter生效
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private UserDetailsService userDetailsService;

  @Autowired private BCryptPasswordEncoder passwordEncoder;
  /*
  在这里声明，无法再Service中装配
   */
  /*
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
      return new BCryptPasswordEncoder();
    }
  */

  @Override
  protected void configure(AuthenticationManagerBuilder builder) throws Exception {
    // 临时使用内存登录的模式测试代码
    // builder.inMemoryAuthentication().withUser("tom").password("123").roles("ADMIN");
    // 正式功能中使用基于数据库的认证
    builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
  }

  @Override
  protected void configure(HttpSecurity security) throws Exception {
    security
        // 对请求进行授权
        .authorizeRequests()
        // 针对登录页进行设置
        .antMatchers("/admin/to/login/page.html")
        // 无条件访问
        .permitAll()
        // 针对静态资源进行设置，无条件访问
        .antMatchers("/bootstrap/**")
        // 针对静态资源进行设置，无条件访问
        .permitAll()
        // 针对静态资源进行设置，无条件访问
        .antMatchers("/crowdfunding/**")
        // 针对静态资源进行设置，无条件访问
        .permitAll()
        // 针对静态资源进行设置，无条件访问
        .antMatchers("/css/**")
        // 针对静态资源进行设置，无条件访问
        .permitAll()
        // 针对静态资源进行设置，无条件访问
        .antMatchers("/fonts/**")
        // 针对静态资源进行设置，无条件访问
        .permitAll()
        // 针对静态资源进行设置，无条件访问
        .antMatchers("/img/**")
        // 针对静态资源进行设置，无条件访问
        .permitAll()
        // 针对静态资源进行设置，无条件访问
        .antMatchers("/jquery/**")
        .permitAll()
        // 针对静态资源进行设置，无条件访问
        .antMatchers("/layer/**")
        // 针对静态资源进行设置，无条件访问
        .permitAll()
        // 针对静态资源进行设置，无条件访问
        .antMatchers("/script/**")
        // 针对静态资源进行设置，无条件访问
        .permitAll()
        // 针对静态资源进行设置，无条件访问
        .antMatchers("/ztree/**")
        .permitAll()
        // 针对分页显示Admin数据设定访问控制
        .antMatchers("/admin/get/page.html")
        // 要求具备经理角色
        //        .hasRole("经理")
        // 要求具备”经理“角色或者”user:get“权限二者之一
        .access("hasRole('经理') or hasAuthority('user:get')")
        // 其他任意的请求
        .anyRequest()
        // 认证后访问
        .authenticated()
        .and()
        .exceptionHandling()
        .accessDeniedHandler(
            new AccessDeniedHandler() {
              @Override
              public void handle(
                  HttpServletRequest request,
                  HttpServletResponse response,
                  AccessDeniedException accessDeniedException)
                  throws IOException, ServletException {
                request.setAttribute(
                    "exception", new Exception(CrowdConstant.MESSAGE_ACCESS_DENIED));
                request
                    .getRequestDispatcher("/WEB-INF/system-error.jsp")
                    .forward(request, response);
              }
            })
        .and()
        // 防跨站请求伪造功能
        .csrf()
        // 禁用
        .disable()
        // 开启表单登录功能
        .formLogin()
        // 指定登录页面
        .loginPage("/admin/to/login/page.html")
        // 指定处理登录请求的地址
        .loginProcessingUrl("/security/do/login.html")
        // 指定登录成功后前往的地址
        .defaultSuccessUrl("/admin/to/main/page.html")
        .permitAll()
        // 账号的请求参数名称
        .usernameParameter("loginAcct")
        // 密码的请求参数名称
        .passwordParameter("userPswd")
        .and()
        // 开启退出登录功能
        .logout()
        // 指定退出登录地址
        .logoutUrl("/security/do/logout.html")
        // 指定退出登录成功以后前往的地址
        .logoutSuccessUrl("/admin/to/main/page.html");
  }
}
