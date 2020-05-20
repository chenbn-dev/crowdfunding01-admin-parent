package cn.chenbonian.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auth {
  private Integer id;

  private String name;

  private String title;

  private Integer categoryId;
}
