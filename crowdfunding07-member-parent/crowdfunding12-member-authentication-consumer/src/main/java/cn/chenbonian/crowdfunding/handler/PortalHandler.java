package cn.chenbonian.crowdfunding.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chbn
 * @create 2020-06-06 9:36
 */
@Controller
public class PortalHandler {

  @RequestMapping(value = "/", produces = "application/json;charset=utf-8")
  public String portal() {
    // 这里实际开发中需要加载数据，省略首页加载数据的操作
    return "portal";
  }
}
