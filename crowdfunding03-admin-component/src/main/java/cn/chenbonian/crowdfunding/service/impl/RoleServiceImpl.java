package cn.chenbonian.crowdfunding.service.impl;

import cn.chenbonian.crowdfunding.entity.Role;
import cn.chenbonian.crowdfunding.entity.RoleExample;
import cn.chenbonian.crowdfunding.mapper.RoleMapper;
import cn.chenbonian.crowdfunding.service.api.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chbn
 * @create 2020-05-13 22:41
 */
@Service
public class RoleServiceImpl implements RoleService {

  @Autowired private RoleMapper roleMapper;

  @Override
  public void removeRole(List<Integer> roleIdList) {
    RoleExample roleExample = new RoleExample();
    RoleExample.Criteria criteria = roleExample.createCriteria();
    // delete form t_role where id in(5,8,12)
    criteria.andIdIn(roleIdList);
    roleMapper.deleteByExample(roleExample);
  }

  @Override
  public void updateRole(Role role) {
    roleMapper.updateByPrimaryKey(role);
  }

  @Override
  public void saveRole(Role role) {
    roleMapper.insert(role);
  }

  @Override
  public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {
    // 1.开启分页的功能
    PageHelper.startPage(pageNum, pageSize);
    // 2.执行查询
    List<Role> roleList = roleMapper.selectRoleByKeyword(keyword);
    // 3.封装为PageInfo对象返回
    return new PageInfo<>(roleList);
  }
}
