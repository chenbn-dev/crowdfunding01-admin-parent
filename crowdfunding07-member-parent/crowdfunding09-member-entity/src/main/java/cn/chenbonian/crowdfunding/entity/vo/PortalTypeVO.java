package cn.chenbonian.crowdfunding.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chbn
 * @create 2020-06-16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortalTypeVO {
  private Integer projectId;
  private String projectName;
  private String headerPicturePath;
  private Integer money;
  private String deployDate;
  private Integer percentage;
  private Integer supporter;
}
