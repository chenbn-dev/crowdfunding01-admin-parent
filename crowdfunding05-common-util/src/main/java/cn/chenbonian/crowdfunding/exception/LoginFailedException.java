package cn.chenbonian.crowdfunding.exception;

/**
 * 登录失败后抛出的异常
 *
 * @author chbn
 * @create 2020-05-06 23:31
 */
public class LoginFailedException extends RuntimeException {

  public LoginFailedException() {}

  public LoginFailedException(String message) {
    super(message);
  }

  public LoginFailedException(String message, Throwable cause) {
    super(message, cause);
  }

  public LoginFailedException(Throwable cause) {
    super(cause);
  }

  public LoginFailedException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
