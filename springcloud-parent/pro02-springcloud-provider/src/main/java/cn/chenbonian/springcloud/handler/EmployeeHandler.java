package cn.chenbonian.springcloud.handler;

import cn.chenbonian.springcloud.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chbn
 * @create 2020-06-02 0:07
 */
@RestController
public class EmployeeHandler {
  @RequestMapping("/provider/get/employee/remote")
  public Employee getEmployeeRemote() {
    return new Employee(555, "tom555", 555.55);
  }
}
