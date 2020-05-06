package cn.chenbonian.crowdfunding.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chbn
 * @create 2020-05-06 12:49
 */
public class CrowdUtil {

  /**
   * 判断当前请求是否为Ajax请求
   *
   * @param request 请求对象
   * @return true：当前请求是Ajax请求 false：当前请求不是Ajax请求
   */
  public static boolean judgeRequestType(HttpServletRequest request) {
    // 1. 获取请求消息头
    String acceptHeader = request.getHeader("accept");
    String xRequestHeader = request.getHeader("X-Requested-With");
    //
    return acceptHeader != null && acceptHeader.contains("application/json")
        || (xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
  }
}
