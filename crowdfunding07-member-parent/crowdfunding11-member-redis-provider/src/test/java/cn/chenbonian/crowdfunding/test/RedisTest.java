package cn.chenbonian.crowdfunding.test;

import cn.chenbonian.crowdfunding.constant.CrowdConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author chbn
 * @create 2020-06-05 23:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
  // private Logger logger = LoggerFactory.getLogger(RedisTest.class);
  @Autowired private StringRedisTemplate redisTemplate;

  @Test
  public void testSet() {
    ValueOperations<String, String> operations = redisTemplate.opsForValue();
    operations.set(CrowdConstant.REDIS_CODE_PREFIX+"18153971786", "123456");
  }

  @Test
  public void testExSet() {
    ValueOperations<String, String> operations = redisTemplate.opsForValue();
    operations.set(CrowdConstant.REDIS_CODE_PREFIX+"18153971786", "123456", 500, TimeUnit.DAYS);
  }
}
