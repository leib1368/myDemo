package leib.demo;

import leib.demo.dao.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = VueApplication.class)
@RunWith(SpringRunner.class)
public class TestUserDAO {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testFindAll(){
        userDAO.findAll().forEach(user -> System.out.println("user = " + user));
    }
}
