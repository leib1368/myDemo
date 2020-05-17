package leib.demo.service;

import leib.demo.dao.UserDAO;
import leib.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:Leib
 * @Date 2020/5/16 21:19
 */
@Service
@Transactional
public class UserServciceImpl  implements  UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        return userDAO.login(user);
    }
}