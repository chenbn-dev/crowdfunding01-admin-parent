package cn.chenbonian.springcloud.handler;

import cn.chenbonian.springcloud.api.EmployeeRemoteService;
import cn.chenbonian.springcloud.entity.Employee;
import cn.chenbonian.springcloud.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chbn
 * @create 2020-06-02 23:39
 */
@RestController
public class FeignHumanResourceHandler {

  // 装配调用远程微服务的接口，后面向调用本地方法一样直接使用
  @Autowired private EmployeeRemoteService employeeRemoteService;

  @RequestMapping("/feign/consumer/test/fallback")
  public ResultEntity<Employee> testFallBack(@RequestParam("signal") String signal) {
    return employeeRemoteService.getEmp(signal);
  }

  @RequestMapping("/feign/consumer/get/emp")
  public Employee getEmployeeRemote() {
    return employeeRemoteService.getEmployeeRemote();
  }

  @RequestMapping("/feign/consumer/search")
  public List<Employee> getEmpListRemote(String keyword) {
    return employeeRemoteService.getEmpListRemote(keyword);
  }
}
