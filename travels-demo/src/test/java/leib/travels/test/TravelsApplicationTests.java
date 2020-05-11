package leib.travels.test;


import leib.travels.dao.UserDao;
import leib.travels.enity.User;
import leib.travels.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TravelsApplicationTests {

    @Autowired
    private UserService userService;

/*    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("leib123");
        user.setPassword("333");
        user.setEmail("2@qq.com");
        userService.register(user);
    }*/

    @Autowired
    private UserDao userDao;

    @Test
    public void testLogin(){

        User u1 = userDao.findByUsername("leib");
        System.out.println(u1);
    }

}
