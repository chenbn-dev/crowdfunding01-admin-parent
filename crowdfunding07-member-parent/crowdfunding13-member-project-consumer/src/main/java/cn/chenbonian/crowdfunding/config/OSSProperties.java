package cn.chenbonian.crowdfunding.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chbn
 * @create 2020-06-12 12:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OSSProperties {
  private String endPoint;
  private String bucketName;
  private String accessKeyId;
  private String accessKeySecret;
  private String bucketDomain;
}
