package cn.chenbonian.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chbn
 * @create 2020-06-04 0:15
 */
@Component
public class MyZuulFilter extends ZuulFilter {

  //  Logger logger = LoggerFactory.getLogger(MyZuulFilter.class);
  /**
   * 判断当前请求是否要过滤
   *
   * <p>要过滤： 返回true，继续执行run()方法
   *
   * <p>不过滤： 返回false，直接放行
   *
   * @return
   */
  @Override
  public boolean shouldFilter() {
    // 1.获取RequestContext对象
    RequestContext requestContext = RequestContext.getCurrentContext();
    // 2.获取Request对象
    HttpServletRequest request = requestContext.getRequest();
    // 判读当前请求参数是否为signal=hello
    String parameter = request.getParameter("signal");
    return "hello".equals(parameter);
  }

  @Override
  public Object run() throws ZuulException {
    System.out.println("当前请求要进行过滤，run()方法执行了");
    // 当前实现会忽略这个方法的返回值，所以返回null，不做特殊处理
    return null;
  }

  @Override
  public String filterType() {
    // 返回当前过滤器的类型，决定当前过滤器在什么时候执行
    // pre表示在目标微服务前执行
    String filterType = "pre";
    return filterType;
  }

  @Override
  public int filterOrder() {
    return 0;
  }
}
