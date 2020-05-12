package cn.chenbonian.crowdfunding.exception;

/**
 * @author chbn
 * @create 2020-05-12 23:36
 */
public class LoginAcctAlreadyInUseException extends RuntimeException {
  public LoginAcctAlreadyInUseException() {
    super();
  }

  public LoginAcctAlreadyInUseException(String message) {
    super(message);
  }

  public LoginAcctAlreadyInUseException(String message, Throwable cause) {
    super(message, cause);
  }

  public LoginAcctAlreadyInUseException(Throwable cause) {
    super(cause);
  }

  protected LoginAcctAlreadyInUseException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
