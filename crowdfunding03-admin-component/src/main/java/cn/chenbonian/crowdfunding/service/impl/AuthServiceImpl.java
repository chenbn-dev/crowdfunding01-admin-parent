package cn.chenbonian.crowdfunding.service.impl;

import cn.chenbonian.crowdfunding.entity.Auth;
import cn.chenbonian.crowdfunding.entity.AuthExample;
import cn.chenbonian.crowdfunding.mapper.AuthMapper;
import cn.chenbonian.crowdfunding.service.api.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author chbn
 * @create 2020-05-18 23:56
 */
@Service
public class AuthServiceImpl implements AuthService {
  @Autowired private AuthMapper authMapper;

  @Override
  public List<String> getAssignAuthNameByAdminId(Integer adminId) {
    return authMapper.selectAssignAuthNameByAdminId(adminId);
  }

  @Override
  public void saveRoleAuthRelathinship(Map<String, List<Integer>> map) {
    // 1.获取 roleId 的值
    List<Integer> roleIdList = map.get("roleId");
    Integer roleId = roleIdList.get(0);
    // 2.删除旧关联关系数据
    authMapper.deleteOldRelationship(roleId);
    // 3.获取 authIdList
    List<Integer> authIdList = map.get("authIdArray");
    // 4.判断 authIdList 是否有效
    if (authIdList != null && authIdList.size() > 0) {
      authMapper.insertNewRelationship(roleId, authIdList);
    }
  }

  @Override
  public List<Integer> getAssignAuthIdByRoleId(Integer roleId) {
    return authMapper.selectAssignAuthIdByRoleId(roleId);
  }

  @Override
  public List<Auth> getAll() {
    return authMapper.selectByExample(new AuthExample());
  }
}
