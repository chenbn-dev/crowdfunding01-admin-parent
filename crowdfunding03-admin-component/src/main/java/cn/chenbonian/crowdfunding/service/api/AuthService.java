package cn.chenbonian.crowdfunding.service.api;

import cn.chenbonian.crowdfunding.entity.Auth;

import java.util.List;
import java.util.Map;

/**
 * @author chbn
 * @create 2020-05-18 23:56
 */
public interface AuthService {

  void saveRoleAuthRelathinship(Map<String, List<Integer>> map);

  List<Integer> getAssignAuthIdByRoleId(Integer roleId);

  List<Auth> getAll();
}
