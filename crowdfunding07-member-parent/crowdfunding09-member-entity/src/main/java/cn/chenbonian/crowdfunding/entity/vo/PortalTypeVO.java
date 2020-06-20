package cn.chenbonian.crowdfunding.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chbn
 * @create 2020-06-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortalTypeVO {

  private Integer id;
  private String name;
  private String remark;

  private List<PortalProjectVO> portalProjectVOList;
}
