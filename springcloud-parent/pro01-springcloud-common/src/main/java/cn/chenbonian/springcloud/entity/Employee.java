package cn.chenbonian.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chbn
 * @create 2020-06-01 23:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
  private Integer empId;
  private String empName;
  private Double empSalary;
}
