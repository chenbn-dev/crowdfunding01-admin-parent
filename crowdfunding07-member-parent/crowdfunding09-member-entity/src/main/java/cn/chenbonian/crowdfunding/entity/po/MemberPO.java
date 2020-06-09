package cn.chenbonian.crowdfunding.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 专门用于封装实体数据
 *
 * @author chbn
 * @create 2020-06-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberPO {
  private Integer id;

  private String loginacct;

  private String userpswd;

  private String username;

  private String email;

  private Integer authstatus;

  private Integer usertype;

  private String realname;

  private String cardnum;

  private Integer accttype;
}
