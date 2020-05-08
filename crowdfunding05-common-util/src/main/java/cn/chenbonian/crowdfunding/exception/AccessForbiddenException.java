package cn.chenbonian.crowdfunding.exception;

/**
 * 表示用户没有登录就访问受保护资源时抛出的异常
 *
 * @author chbn
 * @create 2020-05-08 23:32
 */
public class AccessForbiddenException extends RuntimeException {
  public AccessForbiddenException() {
    super();
  }

  public AccessForbiddenException(String message) {
    super(message);
  }

  public AccessForbiddenException(String message, Throwable cause) {
    super(message, cause);
  }

  public AccessForbiddenException(Throwable cause) {
    super(cause);
  }

  protected AccessForbiddenException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
