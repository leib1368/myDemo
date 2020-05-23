package leib.demo.service;

import leib.demo.dao.UserDAO;
import leib.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.UserDataHandler;

import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/5/23 16:31
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll() ;
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(String id) {
        userDAO.delete(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }
}
