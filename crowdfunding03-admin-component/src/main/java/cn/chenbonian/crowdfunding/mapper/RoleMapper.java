package cn.chenbonian.crowdfunding.mapper;

import cn.chenbonian.crowdfunding.entity.Role;
import cn.chenbonian.crowdfunding.entity.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

  List<Role> selectAssignedRole(Integer adminId);

  List<Role> selectUnAssignedRole(Integer adminId);

  List<Role> selectRoleByKeyword(String keyword);

  int countByExample(RoleExample example);

  int deleteByExample(RoleExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(Role record);

  int insertSelective(Role record);

  List<Role> selectByExample(RoleExample example);

  Role selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

  int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

  int updateByPrimaryKeySelective(Role record);

  int updateByPrimaryKey(Role record);
}
