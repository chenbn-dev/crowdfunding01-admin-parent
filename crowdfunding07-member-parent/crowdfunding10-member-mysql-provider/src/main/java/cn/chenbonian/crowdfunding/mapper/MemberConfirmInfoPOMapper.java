package cn.chenbonian.crowdfunding.mapper;

import cn.chenbonian.crowdfunding.entity.po.MemberConfirmInfoPO;
import cn.chenbonian.crowdfunding.entity.po.MemberConfirmInfoPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberConfirmInfoPOMapper {
  int countByExample(MemberConfirmInfoPOExample example);

  int deleteByExample(MemberConfirmInfoPOExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(MemberConfirmInfoPO record);

  int insertSelective(MemberConfirmInfoPO record);

  List<MemberConfirmInfoPO> selectByExample(MemberConfirmInfoPOExample example);

  MemberConfirmInfoPO selectByPrimaryKey(Integer id);

  int updateByExampleSelective(
      @Param("record") MemberConfirmInfoPO record,
      @Param("example") MemberConfirmInfoPOExample example);

  int updateByExample(
      @Param("record") MemberConfirmInfoPO record,
      @Param("example") MemberConfirmInfoPOExample example);

  int updateByPrimaryKeySelective(MemberConfirmInfoPO record);

  int updateByPrimaryKey(MemberConfirmInfoPO record);
}
