package cn.chenbonian.springboot.redis;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootRedisApplicationTests {

  @Autowired private StringRedisTemplate stringRedisTemplate;

  @Test
  public void testReadStringRedisTemplate() {
    // 1.获取用来操作String类型数据的ValueOperations对象
    ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
    // 2.借助ValueOperations存入数据
    String key = "key01";
    String value = "value01";
    operations.set(key, value);

    // 3.读取刚才设置的数据
    Object readValue = operations.get(key);
    System.out.println(readValue);
  }

  @Autowired private RedisTemplate<Object, Object> redisTemplate;

  @Test
  public void testRedisTemplate() {
    // 1.获取用来操作String类型数据的ValueOperations对象
    ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
    // 2.借助ValueOperations存入数据
    Object key = "good";
    Object value = "study";
    operations.set(key, value);

    // 3.读取刚才设置的数据
    Object readValue = operations.get(key);
    System.out.println(readValue);
  }
}
