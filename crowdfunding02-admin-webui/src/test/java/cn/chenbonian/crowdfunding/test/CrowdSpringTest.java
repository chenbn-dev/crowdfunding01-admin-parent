package cn.chenbonian.crowdfunding.test;

import cn.chenbonian.crowdfunding.entity.Admin;
import cn.chenbonian.crowdfunding.mapper.AdminMapper;
import cn.chenbonian.crowdfunding.service.api.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author chbn
 * @create 2020-04-22 23:41
 */
// 在类上标记必要的注解，Spring整合Junit
// 指定 Spring 给 Junit 提供的运行器类
@RunWith(SpringJUnit4ClassRunner.class)
// 加载 Spring 配置文件的注解
@ContextConfiguration(
    locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class CrowdSpringTest {
  @Autowired private DataSource dataSource;

  @Autowired private AdminService adminService;

  @Autowired private AdminMapper adminMapper;

  @Test
  public void testAdmin() {
    Admin admin = new Admin(null, "jerry", "123456", "杰瑞", "jerry@qq.com", null);
    adminService.saveAdmin(admin);
  }

  @Test
  public void testLog() {
    // 1.获取日志记录对象，这里传入的Class对象就是打印日志的类
    Logger logger = LoggerFactory.getLogger(CrowdSpringTest.class);
    // 按照 Debug 级别打印日志
    logger.debug("debug log");
    logger.debug("debug log");
    logger.debug("debug log");

    logger.info("info log");
    logger.info("info log");
    logger.info("info log");

    logger.warn("warn log");
    logger.warn("warn log");
    logger.warn("warn log");

    logger.error("error log");
    logger.error("error log");
    logger.error("error log");
  }

  @Test
  public void testDataSource() throws SQLException {
    // 1.通过数据源对象获取数据源连接
    Connection connection = dataSource.getConnection();
    // 2.打印数据库连接
    System.out.println(connection);
  }

  @Test
  public void testInsertAdmin() {
    Admin admin = new Admin(4, "tom", "123", "汤姆", "tom@qq.com", null);
    Integer rows = adminMapper.insert(admin);
    System.out.println("受影响的行数：" + rows);
  }
}
