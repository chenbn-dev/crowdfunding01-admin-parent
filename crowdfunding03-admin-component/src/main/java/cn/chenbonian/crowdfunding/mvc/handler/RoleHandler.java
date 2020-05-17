package cn.chenbonian.crowdfunding.mvc.handler;

import cn.chenbonian.crowdfunding.entity.Role;
import cn.chenbonian.crowdfunding.service.api.RoleService;
import cn.chenbonian.crowdfunding.util.ResultEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chbn
 * @create 2020-05-13 22:42
 */
@RestController
public class RoleHandler {

  @Autowired private RoleService roleService;

  @RequestMapping("/role/remove/by/role/id/array.json")
  public ResultEntity<String> removeByRoleIdArray(@RequestBody List<Integer> roleList) {
    roleService.removeRole(roleList);
    return ResultEntity.successWithoutData();
  }

  @RequestMapping("/role/update.json")
  public ResultEntity<String> updateRole(Role role) {
    roleService.updateRole(role);
    return ResultEntity.successWithoutData();
  }

  @RequestMapping("/role/save.json")
  public ResultEntity<String> saveRole(Role role) {
    roleService.saveRole(role);
    return ResultEntity.successWithoutData();
  }

  @RequestMapping("/role/get/page/info.json")
  public ResultEntity<PageInfo<Role>> getPageInfo(
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
      @RequestParam(value = "keyword", defaultValue = "") String keyword) {
    // 调用Service方法获取分页数据
    PageInfo<Role> pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);
    // 封装到ResultEntity对象中返回（如果上面的操作抛出异常，交给异常映射机制处理）
    return ResultEntity.successWithData(pageInfo);
  }
}
