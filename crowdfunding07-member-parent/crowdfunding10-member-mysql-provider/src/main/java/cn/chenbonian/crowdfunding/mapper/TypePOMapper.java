package cn.chenbonian.crowdfunding.mapper;

import cn.chenbonian.crowdfunding.entity.po.TypePO;
import cn.chenbonian.crowdfunding.entity.po.TypePOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypePOMapper {
  int countByExample(TypePOExample example);

  int deleteByExample(TypePOExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(TypePO record);

  int insertSelective(TypePO record);

  List<TypePO> selectByExample(TypePOExample example);

  TypePO selectByPrimaryKey(Integer id);

  int updateByExampleSelective(
      @Param("record") TypePO record, @Param("example") TypePOExample example);

  int updateByExample(@Param("record") TypePO record, @Param("example") TypePOExample example);

  int updateByPrimaryKeySelective(TypePO record);

  int updateByPrimaryKey(TypePO record);
}
