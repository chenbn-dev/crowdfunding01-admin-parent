package cn.chenbonian.springboot.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

/**
 * @author chbn
 * @create 2020-05-31 23:40
 */
@Controller
public class TestTemplateHandler {

  @Autowired private ServletContext servletContext;

    @RequestMapping("/test/template/")
  public String testTemplate() {
    System.out.println("执行");
    // 1.将测试数据存入请求域
    //    modelMap.addAttribute("attrNameRequestSocpe", "attrValueRequestSocpe");
    //    // 2.将测试数据存入会话域
    //    session.setAttribute("attrNameSessionSocpe", "attrValueSessionSocpe");
    //    // 3.将测试数据存入应用域
    //    servletContext.setAttribute("attrAPPRequestSocpe", "attrValueAppSocpe");
    //    // 4.为了测试集合遍历，把集合存入请求域
    //    modelMap.addAttribute("list", Arrays.asList("AAA", "BBB", "CCC", "DDD", "EEE"));
    return "hello";
  }

  //  @RequestMapping("/test1/Template1/")
  //  public String testTemplate1(ModelMap modelMap, HttpSession session) {
  //    // 1.将测试数据存入请求域
  //    modelMap.addAttribute("attrNameRequestSocpe", "attrValueRequestSocpe");
  //    // 2.将测试数据存入会话域
  //    session.setAttribute("attrNameSessionSocpe", "attrValueSessionSocpe");
  //    // 3.将测试数据存入应用域
  //    servletContext.setAttribute("attrAPPRequestSocpe", "attrValueAppSocpe");
  //    return "hello";
  //  }
}
