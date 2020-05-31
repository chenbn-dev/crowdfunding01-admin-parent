package cn.chenbonian.springboot.mapper;

import cn.chenbonian.springboot.entity.Emp;

import java.util.List;

/**
 * @author chbn
 * @create 2020-05-31 18:10
 */
public interface EmpMapper {
  List<Emp> selectAll();
}
