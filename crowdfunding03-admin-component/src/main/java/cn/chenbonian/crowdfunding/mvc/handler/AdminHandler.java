package cn.chenbonian.crowdfunding.mvc.handler;

import cn.chenbonian.crowdfunding.constant.CrowdConstant;
import cn.chenbonian.crowdfunding.entity.Admin;
import cn.chenbonian.crowdfunding.service.api.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author chbn
 * @create 2020-05-06 23:49
 */
@Controller
public class AdminHandler {

  @Autowired private AdminService adminService;

  @RequestMapping("/admin/get/page.html")
  public String getPageInfo(
      // 使用@RequestParam注解的defaultValue属性，指定默认值，在请求中没有携带对应参数时使用默认值
      // keyword默认使用空字符串，和SQL语句配合实现两种情况适配
      @RequestParam(value = "keyword", defaultValue = "") String keyword,
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
      ModelMap modelMap) {
    // 调用Service方法获取PageInfo对象
    PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);
    // 将PageInfo对象存入模型
    modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);
    return "admin-page";
  }

  @RequestMapping("admin/do/logout.html")
  public String doLogout(HttpSession session) {
    // 强制session失效
    session.invalidate();
    return "redirect:/admin/to/login/page.html";
  }

  @RequestMapping("/admin/do/login.html")
  public String doLogin(
      @RequestParam("loginAcct") String loginAcct,
      @RequestParam("userPswd") String userPswd,
      HttpSession session) {
    // 调用Service方法执行登录检查
    // 这个方法如果能够返回admin对象，说明登录成功，如果账号密码不正确，这会抛出异常
    Admin admin = adminService.getAdminByLoginAcct(loginAcct, userPswd);
    // 将登录成功返回的admin对象存入Session域
    session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);
    return "redirect:/admin/to/main/page.html";
  }
}
