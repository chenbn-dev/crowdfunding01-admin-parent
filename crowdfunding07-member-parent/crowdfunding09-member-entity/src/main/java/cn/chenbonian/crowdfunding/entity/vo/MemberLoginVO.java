package cn.chenbonian.crowdfunding.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用来存储用户登录后对象的VO类
 *
 * @author chbn
 * @create 2020-06-10 0:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberLoginVO {
  private Integer id;
  private String username;
  private String email;
}
