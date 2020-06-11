package cn.chenbonian.crowdfunding.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chbn
 * @create 2020-06-11 22:42
 */
public class AccessPassResources {
  public static final Set<String> PASS_RESOURCES_SET = new HashSet<>();
  public static final Set<String> STATIC_RESOURCES_SET = new HashSet<>();

  static {
    PASS_RESOURCES_SET.add("/");
    PASS_RESOURCES_SET.add("/auth/member/to/reg/page");
    PASS_RESOURCES_SET.add("/auth/member/to/login/page");
    PASS_RESOURCES_SET.add("/auth/member/logout");
    PASS_RESOURCES_SET.add("/auth/member/do/login");
    PASS_RESOURCES_SET.add("/auth/do/member/register");
    PASS_RESOURCES_SET.add("/auth/member/send/short/message.json");
  }

  static {
    STATIC_RESOURCES_SET.add("bootstrap");
    STATIC_RESOURCES_SET.add("css");
    STATIC_RESOURCES_SET.add("fonts");
    STATIC_RESOURCES_SET.add("img");
    STATIC_RESOURCES_SET.add("jquery");
    STATIC_RESOURCES_SET.add("layer");
    STATIC_RESOURCES_SET.add("script");
    STATIC_RESOURCES_SET.add("ztree");
  }

  /**
   * 用于判断某个servletPath值是否是一个静态资源
   *
   * @param servletPath
   * @return true：是静态资源 false：不是静态资源
   */
  public static boolean judgeCurrentServletPathWetherStaticResource(String servletPath) {
    // 1.排除字符串无效的情况
    if (servletPath == null || servletPath.length() == 0) {
      throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
    }
    // 2.根据“/”拆分 ServletPath 字符串
    String[] split = servletPath.split("/");
    // 3.考虑到第一个斜杠左边经过拆分后得到一个空字符串是数组的第一个元素，所以需要使用下标 1 取第二个元素
    String firstLevelPath = split[1];
    // 4.判断是否在集合中
    return STATIC_RESOURCES_SET.contains(firstLevelPath);
  }

  //  public static void main(String[] args) {
  //    System.out.println(judgeCurrentServletPathWetherStaticResource("/css"));
  //  }
}
