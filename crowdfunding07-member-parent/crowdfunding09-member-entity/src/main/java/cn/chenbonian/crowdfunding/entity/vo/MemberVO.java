package cn.chenbonian.crowdfunding.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 专门用于封装表单数据
 *
 * @author chbn
 * @create 2020-06-08 23:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
  private String loginacct;
  private String userpswd;
  private String username;
  private String email;
  private String phoneNum;
  private String code;
}
