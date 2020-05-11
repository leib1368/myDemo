package leib.demo.service;

import leib.demo.dao.UserDAO;
import leib.demo.entity.User;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@DS("master")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @DS("slave_1")
    public List<User> findAll() {
        return userDAO.selectList(null);
    }

    @Override
    public void save(User user) {
        userDAO.insert(user);
    }
}
