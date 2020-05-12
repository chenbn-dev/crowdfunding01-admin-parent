package cn.chenbonian.crowdfunding.mvc.handler;

import cn.chenbonian.crowdfunding.constant.CrowdConstant;
import cn.chenbonian.crowdfunding.entity.Admin;
import cn.chenbonian.crowdfunding.service.api.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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

  @RequestMapping("/admin/save.html")
  public String save(Admin admin) {
    adminService.saveAdmin(admin);
    return "redirect:/admin/get/page.html?pageNum=" + Integer.MAX_VALUE;
  }

  /**
   * 删除用户 注意事项：1.做逻辑删除，不做物理删除 2.判断是否是当前用户，当前用户不可删除（session中取出admin，比id是否为当前用户id） 3.前端页面弹框提升
   *
   * @param adminId
   * @param pageNum
   * @param keyword
   * @return
   */
  @RequestMapping("/admin/remove/{adminId}/{pageNum}/{keyword}.html")
  public String remove(
      @PathVariable("adminId") Integer adminId,
      @PathVariable("pageNum") Integer pageNum,
      @PathVariable("keyword") String keyword) {
    adminService.remove(adminId);
    // 页面跳转：回到分页页面
    // 尝试方案1：直接转发到admin-page.jsp会无法显示分页数据
    // return "admin-page";
    // 尝试方案2：转发到/admin/get/page.html地址，一旦刷新页面会重复执行删除浪费性能
    // return "forward:/admin/get/page.html";
    // 尝试方案3：重定向到/admin/get/page.html地址
    // 同时为了保持原本所在的页面和查询关键词再附加pageNum和keyword两个请求参数
    return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
  }

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
