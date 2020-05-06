package cn.chenbonian.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chbn
 * @create 2020-05-05 23:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

  private String province;
  private String city;
  private String street;
}
