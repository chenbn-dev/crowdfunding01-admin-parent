package cn.chenbonian.springboot.handler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chbn
 * @create 2020-05-28 23:28
 */
@RestController
public class HelloHandler {

  @RequestMapping("hello")
  public String HelloBoot() {
    return "hello,springboot";
  }
}
