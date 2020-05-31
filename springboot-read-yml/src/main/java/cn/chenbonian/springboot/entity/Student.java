package cn.chenbonian.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author chbn
 * @create 2020-05-30 10:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// 当前类存放读取yml配置文件的数据，要求当前类也在IOC容器中
@Component
// @ConfigurationProperties表示和yml配置文件对应，读取其中数据，其中prefix属性表示和yml配置文件中以“student”开头的配置项对应
@ConfigurationProperties(prefix = "student")
public class Student {
  private Integer stuId;
  private String stuName;
  private Boolean graduated;
  private String[] subject;
  private Date birthday;
  private Map<String, String> teachers;
  private Address address;

  @Override
  public String toString() {
    return "Student{"
        + "stuId="
        + stuId
        + ", stuName='"
        + stuName
        + '\''
        + ", graduated="
        + graduated
        + ", subject="
        + Arrays.toString(subject)
        + ", birthday="
        + birthday
        + ", teachers="
        + teachers
        + ", address="
        + address
        + '}';
  }
}
