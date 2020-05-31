package cn.chenbonian.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chbn
 * @create 2020-05-30 10:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
  private String province;
  private String city;
  private String street;
}
