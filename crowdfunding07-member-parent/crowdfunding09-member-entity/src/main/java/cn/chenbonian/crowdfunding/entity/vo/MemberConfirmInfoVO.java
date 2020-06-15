package cn.chenbonian.crowdfunding.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chbn
 * @create 2020-06-15 8:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberConfirmInfoVO implements Serializable {
  private static final long serialVersionUID = 1L;
  // 易付宝账号
  private String paynum;
  // 法人身份证号
  private String cardnum;
}
