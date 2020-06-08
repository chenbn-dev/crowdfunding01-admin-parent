package cn.chenbonian.crowdfunding.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chbn
 * @create 2020-06-08 8:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "short.message")
public class ShortMessageProperties {
  private String host;
  private String path;
  private String method;
  private String appCode;
  private String sign;
  private String skin;
}
