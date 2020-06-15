package cn.chenbonian.crowdfunding.mapper;

import cn.chenbonian.crowdfunding.entity.po.ProjectPO;
import cn.chenbonian.crowdfunding.entity.po.ProjectPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectPOMapper {
  int countByExample(ProjectPOExample example);

  int deleteByExample(ProjectPOExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(ProjectPO record);

  int insertSelective(ProjectPO record);

  List<ProjectPO> selectByExample(ProjectPOExample example);

  ProjectPO selectByPrimaryKey(Integer id);

  int updateByExampleSelective(
          @Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

  int updateByExample(
      @Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

  int updateByPrimaryKeySelective(ProjectPO record);

  int updateByPrimaryKey(ProjectPO record);
}
