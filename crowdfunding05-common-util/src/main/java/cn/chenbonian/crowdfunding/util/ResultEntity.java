package cn.chenbonian.crowdfunding.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一整个项目中Ajax请求返回的结果（未来也可用用于分布式架构各个模块间调用时返回统一类型）
 *
 * @author chbn
 * @create 2020-05-06 10:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity<T> {

  public static final String SUCCESS = "SUCCESS";
  public static final String FAILED = "FAILED";

  // 封装当前请求处理的结果是成功还是失败
  private String result;
  // 请求处理失败时返回的错误的消息
  private String message;
  // 要返回的数据
  private T data;

  /**
   * 请求处理成功且不需要返回数据时使用的工具方法
   *
   * @param <Type>
   * @return
   */
  public static <Type> ResultEntity<Type> successWithoutData() {
    return new ResultEntity<Type>(SUCCESS, null, null);
  }

  /**
   * 请求处理成功且需要返回数据时使用的工具方法
   *
   * @param <Type>
   * @return
   */
  public static <Type> ResultEntity<Type> successWithData(Type data) {
    return new ResultEntity<Type>(SUCCESS, null, data);
  }

  /**
   * 请求处理失败后使用的工具方法
   *
   * @param message 请求失败的错误消息
   * @return
   */
  public static <Type> ResultEntity<Type> failed(String message) {
    return new ResultEntity<Type>(FAILED, message, null);
  }
}
