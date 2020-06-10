package cn.chenbonian.crowdfunding.constant;

/**
 * @author chbn
 * @create 2020-05-06 15:52
 */
public class CrowdConstant {

  public static final String MESSAGE_LOGIN_FAILED_NO_SUSH_USER = "登录失败！用户名不存在！";
  public static final String MESSAGE_LOGIN_FAILED_WRONG_PASSWORD = "登录失败！密码错误！";
  public static final String MESSAGE_LOGIN_ACCT_ALREADY_IN_USE = "用户名已被占用!";
  public static final String MESSAGE_ACCESS_FORBIDEN = "请登录以后再访问！";
  public static final String MESSAGE_STRING_INVALIDATE = "输入字符不合法！请不要传入空字符串";
  public static final String MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE = "系统错误：登录账号不唯一！";
  public static final String MESSAGE_ACCESS_DENIED = "没有权限访问该资源！";
  public static final String MESSAGE_CODE_NOT_EXISTS = "验证码已过期，请检查手机号是否正确或重新发送！";
  public static final String MESSAGE_CODE_NOT_INVALID = "验证码错误！";

  public static final String ATTR_NAME_EXCEPTION = "exception";
  public static final String ATTR_NAME_LOGIN_ADMIN = "loginAdmin";
  public static final String ATTR_NAME_LOGIN_MEMBER = "loginMember";
  public static final String ATTR_NAME_PAGE_INFO = "pageInfo";
  public static final String ATTR_NAME_MESSAGE = "message";

  public static final String REDIS_CODE_PREFIX = "REDIS_CODE_PREFIX_";
}
