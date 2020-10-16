package leib.demo;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import leib.demo.dao.UserDAO;
import leib.demo.entity.User;
import leib.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ElementUsersBackApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
/*        User user = new User();
        user.setName("法外狂徒");
        user.setBir(new Date());
        user.setAddress("天龙人");
        userService.save(user);
        userService.findAll().forEach(userAll-> System.out.println(userAll));*/
    }
    @Autowired
    private UserDAO userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);

        userList.forEach(System.out::println);
    }
}
