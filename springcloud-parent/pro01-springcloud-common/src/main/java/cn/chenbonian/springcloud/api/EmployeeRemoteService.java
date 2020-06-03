package cn.chenbonian.springcloud.api;

import cn.chenbonian.springcloud.entity.Employee;
import cn.chenbonian.springcloud.factory.MyFallBackFactory;
import cn.chenbonian.springcloud.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author chbn
 * @create 2020-06-02 23:21
 */

// @FeignClient注解表示当前接口和一个Provider对应，注解中value属性指定要调用的Provider的微服务名称
// 注解中的 fallbackFactory 属性，指定Provider不可用时提供备用方案的工厂类型
@FeignClient(value = "provider1000", fallbackFactory = MyFallBackFactory.class)
public interface EmployeeRemoteService {

  @RequestMapping("/provider/circuit/breaker/get/emp")
  public ResultEntity<Employee> getEmp(@RequestParam("signal") String signal);
  // 远程调用的接口方法；
  // 要求RequestMapping注解映射的地址一致
  // 要求方法声明一致
  // 用来获取请求参数的@RequestParam、@PathVariable、@RequestBody
  @RequestMapping("/provider/get/employee/remote")
  public Employee getEmployeeRemote();

  @RequestMapping("/provider/get/employee/list/remote")
  public List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword);
}
