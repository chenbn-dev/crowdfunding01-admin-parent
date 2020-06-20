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
  // ����
  private Integer id;
  // ������
  private String orderNum;
  // ֧������ˮ����
  private String payOrderNum;
  // �������
  private Double orderAmount;
  // �Ƿ񿪷�Ʊ
  private Integer invoice;
  // ��Ʊ̧ͷ
  private String invoiceTitle;
  // ��ע
  private String orderRemark;
  private Integer addressId;
  private OrderProjectVO orderProjectVO;
}
