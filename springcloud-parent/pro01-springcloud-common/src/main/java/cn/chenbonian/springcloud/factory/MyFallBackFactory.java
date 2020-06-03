package cn.chenbonian.springcloud.factory;

import cn.chenbonian.springcloud.api.EmployeeRemoteService;
import cn.chenbonian.springcloud.entity.Employee;
import cn.chenbonian.springcloud.util.ResultEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 1：实现Consumer端服务降级功能 2：实现FallbackFactory接口时，要传入@FeignClien注解标记的接口类型
 * 3：在create()方法中返回个 @FeignClien注解标注的接口类型的对象，当 Provider调用失败后，会执行这个对象对应的方法
 *
 * @author chbn
 * @create 2020-06-03 12:52
 */
@Component
public class MyFallBackFactory implements FallbackFactory<EmployeeRemoteService> {
  public EmployeeRemoteService create(final Throwable cause) {
    return new EmployeeRemoteService() {
      public ResultEntity<Employee> getEmp(String signal) {
        return ResultEntity.failed(cause.getMessage() + "降级机制生效");
      }

      public Employee getEmployeeRemote() {
        return null;
      }

      public List<Employee> getEmpListRemote(String keyword) {
        return null;
      }
    };
  }
}
