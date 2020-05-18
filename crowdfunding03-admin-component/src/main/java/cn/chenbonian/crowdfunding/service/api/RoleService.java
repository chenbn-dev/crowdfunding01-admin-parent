package cn.chenbonian.crowdfunding.service.api;

import cn.chenbonian.crowdfunding.entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author chbn
 * @create 2020-05-13 22:41
 */
public interface RoleService {

  List<Role> getAssignedRole(Integer adminId);

  List<Role> getUnAssignedRole(Integer adminId);

  void removeRole(List<Integer> roleIdList);

  void updateRole(Role role);

  void saveRole(Role role);

  PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword);
}
