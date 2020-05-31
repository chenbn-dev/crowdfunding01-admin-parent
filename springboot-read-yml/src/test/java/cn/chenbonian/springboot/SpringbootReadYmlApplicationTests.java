package cn.chenbonian.springboot;

import cn.chenbonian.springboot.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootReadYmlApplicationTests {

  @Autowired private Student student;
  Logger logger = LoggerFactory.getLogger(SpringbootReadYmlApplicationTests.class);

  @Value("${chenbonian.best.wishes}")
  private String wishes;

  @Test
  public void testReadValue() {
    System.out.println(wishes);
  }

  @Test
  public void contextLoads() {
    System.out.println(student.toString());
    //    logger.debug(student.toString());
  }
}
