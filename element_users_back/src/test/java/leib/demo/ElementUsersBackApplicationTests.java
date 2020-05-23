package leib.demo;

import leib.demo.entity.User;
import leib.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ElementUsersBackApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setName("法外狂徒");
        user.setBir(new Date());
        user.setAddress("天龙人");
        userService.save(user);
        userService.findAll().forEach(userAll-> System.out.println(userAll));
    }

}
