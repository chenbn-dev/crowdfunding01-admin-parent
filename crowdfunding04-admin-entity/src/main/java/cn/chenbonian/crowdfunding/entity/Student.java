package cn.chenbonian.crowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author chbn
 * @create 2020-05-05 23:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  private Integer stuId;
  private String stuName;
  private Address address;
  private List<Subject> subjectList;
  private Map<String, String> map;
}
