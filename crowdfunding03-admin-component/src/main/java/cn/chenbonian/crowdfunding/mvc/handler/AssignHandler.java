package cn.chenbonian.crowdfunding.mvc.handler;

import cn.chenbonian.crowdfunding.entity.Auth;
import cn.chenbonian.crowdfunding.entity.Role;
import cn.chenbonian.crowdfunding.service.api.AdminService;
import cn.chenbonian.crowdfunding.service.api.AuthService;
import cn.chenbonian.crowdfunding.service.api.RoleService;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author chbn
 * @create 2020-05-17 23:56
 */
@Controller
public class AssignHandler {

  @Autowired private AdminService adminService;
  @Autowired private RoleService roleService;
  @Autowired private AuthService authService;

  @ResponseBody
  @RequestMapping("/assign/do/role/assign/auth.json")
  public ResultEntity<String> saveRoleAuthRelathinship(
      @RequestBody Map<String, List<Integer>> map) {
    authService.saveRoleAuthRelathinship(map);
    return ResultEntity.successWithoutData();
  }

  @ResponseBody
  @RequestMapping("/assign/get/assigned/auth/id/by.role/id.json")
  public ResultEntity<List<Integer>> getAssignAuthIdByRoleId(
      @RequestParam("roleId") Integer roleId) {
    List<Integer> authIdList = authService.getAssignAuthIdByRoleId(roleId);
    return ResultEntity.successWithData(authIdList);
  }

  @ResponseBody
  @RequestMapping("assign/get/all/auth.json")
  public ResultEntity<List<Auth>> getAllAuth() {
    List<Auth> authList = authService.getAll();
    return ResultEntity.successWithData(authList);
  }

  @RequestMapping("/assign/do/role/assign.json")
  public String saveAdminRoleRelationship(
      @RequestParam("adminId") Integer adminId,
      @RequestParam("pageNum") Integer pageNum,
      @RequestParam("keyword") String keyword,
      // 允许用户在页面上取消所有已分配角色再提交表单，所以可以不提供roleIdList请求参数
      // 设置 required = false表示这个请求参数不是必须的
      @RequestParam(value = "roleIdList", required = false) List<Integer> roleIdList) {
    adminService.saveAdminRoleRelationship(adminId, roleIdList);
    return "redirect:/admin/get/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
  }

  @RequestMapping("/assign/to/assign/role/page.html")
  public String toAssignRolePage(@RequestParam("adminId") Integer adminId, ModelMap modelMap) {
    // 1.查询已分配的角色
    List<Role> assignedRoleList = roleService.getAssignedRole(adminId);
    // 2。查询未分配的角色
    List<Role> unAssignedRoleList = roleService.getUnAssignedRole(adminId);
    // 3.存入模型
    modelMap.addAttribute("assignedRoleList", assignedRoleList);
    modelMap.addAttribute("unAssignedRoleList", unAssignedRoleList);
    return "assign-role";
  }
}
