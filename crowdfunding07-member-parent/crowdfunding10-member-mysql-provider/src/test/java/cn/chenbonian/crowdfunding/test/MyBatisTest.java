package cn.chenbonian.crowdfunding.test;

import cn.chenbonian.crowdfunding.entity.po.MemberPO;
import cn.chenbonian.crowdfunding.mapper.MemberPOMapper;
import cn.chenbonian.crowdfunding.mapper.ProjectPOMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author chbn
 * @create 2020-06-05 8:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {
  @Autowired private DataSource dataSource;

  @Autowired private MemberPOMapper memberPOMapper;

  @Resource private ProjectPOMapper projectPOMapper;
  private Logger logger = LoggerFactory.getLogger(MyBatisTest.class);



  @Test
  public void testMapper() {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    String source = "123123";

    String encode = passwordEncoder.encode(source);

    MemberPO memberPO =
        new MemberPO(null, "jack", encode, "杰克", "jack@qq.com", 1, 1, "杰克", "123123", 2);

    memberPOMapper.insert(memberPO);
  }

  @Test
  public void testConnection() throws SQLException {

    Connection connection = dataSource.getConnection();

    logger.debug(connection.toString());
  }
}
