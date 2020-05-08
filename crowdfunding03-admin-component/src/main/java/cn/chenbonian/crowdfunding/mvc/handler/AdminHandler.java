package cn.chenbonian.crowdfunding.mvc.handler;

import cn.chenbonian.crowdfunding.constant.CrowdConstant;
import cn.chenbonian.crowdfunding.entity.Admin;
import cn.chenbonian.crowdfunding.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
