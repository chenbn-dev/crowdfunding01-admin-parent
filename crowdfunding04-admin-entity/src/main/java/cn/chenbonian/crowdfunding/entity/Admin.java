package cn.chenbonian.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chbn
 * @create 2020-04-21 0:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

  private Integer id;
  private String loginAcct;
  private String userPswd;
  private String userName;
  private String email;
  private String createTime;

}
