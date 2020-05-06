package cn.chenbonian.crowdfunding.mvc.handler;

import cn.chenbonian.crowdfunding.entity.Admin;
import cn.chenbonian.crowdfunding.entity.Student;
import cn.chenbonian.crowdfunding.service.api.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author chbn
 * @create 2020-05-03 20:55
 */
@Controller
public class TestHandler {

  @Autowired private AdminService adminService;
  private Logger logger = LoggerFactory.getLogger(TestHandler.class);

  @ResponseBody
  @RequestMapping("/send/compose/object.html")
  public String testReceiveComposeObject(@RequestBody Student student) {
    logger.info(student.toString());
    return "success";
  }

  @ResponseBody
  @RequestMapping("/send/array/three.html")
  public String testReceiveArrayThree(@RequestBody List<Integer> array) {
    for (Integer number : array) {
      logger.info("number=" + number);
    }
    return "success";
  }

  @ResponseBody
  @RequestMapping("/send/array/two.html")
  public String testReceiveArrayTwo(@RequestParam("array") List<Integer> array) {
    for (Integer number : array) {
      System.out.println("number=" + number);
    }
    return "success";
  }

  @ResponseBody
  @RequestMapping("/send/array/one.html")
  public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array) {
    for (Integer number : array) {
      System.out.println("number=" + number);
    }
    return "success";
  }

  @RequestMapping("/test/ssm.html")
  public String testSsm(ModelMap modelMap) {
    List<Admin> adminList = adminService.getAll();
    modelMap.addAttribute("adminList", adminList);
    return "target";
  }
}
