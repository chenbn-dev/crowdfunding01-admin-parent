package cn.chenbonian.springcloud.handler;

import cn.chenbonian.springcloud.entity.Employee;
import cn.chenbonian.springcloud.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chbn
 * @create 2020-06-02 0:07
 */
@RestController
public class EmployeeHandler {

  // @HystrixCommand 注解通过 fallbackMethod 属性指定断路情况下要调用的备份方法
  @HystrixCommand(fallbackMethod = "getEmpBackup")
  @RequestMapping("/provider/circuit/breaker/get/emp")
  public ResultEntity<Employee> getEmp(@RequestParam("signal") String signal)
      throws InterruptedException {
    if ("quick-bang".equals(signal)) {
      throw new RuntimeException();
    }
    if ("slow-bang".equals(signal)) {
      Thread.sleep(5000);
    }
    return ResultEntity.successWithData(new Employee(666, "empName666", 666.66));
  }

  public ResultEntity<Employee> getEmpBackup(@RequestParam("signal") String signal) {
    return ResultEntity.failed("方法执行出现问题，执行断路 signal=" + signal);
  }

  @RequestMapping("/provider/get/employee/list/remote")
  public List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword) {
    System.out.println("keyword=" + keyword);
    List<Employee> empList = new ArrayList<Employee>();
    empList.add(new Employee(33, "empName33", 33.33));
    empList.add(new Employee(44, "empName44", 44.44));
    empList.add(new Employee(55, "empName55", 55.55));
    return empList;
  }

  @RequestMapping("/provider/get/employee/remote")
  public Employee getEmployeeRemote() {

    return new Employee(555, "tom555:", 555.55);
  }
  //  @RequestMapping("/provider/get/employee/remote")
  //  public Employee getEmployeeRemote(HttpServletRequest request) {
  //    // 获取当前web应用的端口号
  //    int serverPort = request.getServerPort();
  //
  //    return new Employee(555, "tom555:" + serverPort, 555.55);
  //  }
}
