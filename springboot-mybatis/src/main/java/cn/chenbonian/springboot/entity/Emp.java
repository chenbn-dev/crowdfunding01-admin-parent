package cn.chenbonian.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chbn
 * @create 2020-05-31 17:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
  private Integer empId;
  private String empName;
  private Integer empAge;
}
