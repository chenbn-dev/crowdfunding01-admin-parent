package cn.chenbonian.crowdfunding.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author chbn
 * @create 2020-05-23 9:26
 */
// 表示当前类是一个配置类
@Configuration
// 启动web环境下权限控制功能
@EnableWebSecurity
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private UserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder builder) throws Exception {
    // 临时使用内存登录的模式测试代码
    // builder.inMemoryAuthentication().withUser("tom").password("123").roles("ADMIN");
    // 正式功能中使用基于数据库的认证
    builder.userDetailsService(userDetailsService);
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
        // 其他任意的请求
        .anyRequest()
        // 认证后访问
        .authenticated()
        .and()
        // 方跨站请求伪造功能
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
