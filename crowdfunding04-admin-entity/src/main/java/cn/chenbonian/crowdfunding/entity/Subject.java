package cn.chenbonian.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chbn
 * @create 2020-05-06 9:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

  private String subjectName;
  private Integer subjectScore;
}
