package cn.chenbonian.springboot;

import cn.chenbonian.springboot.entity.Emp;
import cn.chenbonian.springboot.mapper.EmpMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

  @Autowired private EmpMapper empMapper;

  @Test
  public void testSelectAll() {
    List<Emp> selectAll = empMapper.selectAll();
    for (Emp emp : selectAll) {
      System.out.println(emp);
    }
  }
}
