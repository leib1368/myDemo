package leib.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import leib.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisSrpingboot01ApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //操作value 类似String
        redisTemplate.opsForValue().set("hi","leib");
    }

    @Test
    public void test() {
        User user = new User("法外狂徒张三",18);

        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
