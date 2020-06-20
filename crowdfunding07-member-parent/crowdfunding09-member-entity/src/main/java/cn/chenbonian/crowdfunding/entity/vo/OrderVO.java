package cn.chenbonian.crowdfunding.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chbn
 * @create 2020-06-20 23:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO {
  // 主键
  private Integer id;
  // 订单号
  private String orderNum;
  // 支付宝流水单号
  private String payOrderNum;
  // 订单金额
  private Double orderAmount;
  // 是否开发票
  private Integer invoice;
  // 发票抬头
  private String invoiceTitle;
  // 备注
  private String orderRemark;
  private Integer addressId;
  private OrderProjectVO orderProjectVO;
}
