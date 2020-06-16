package leib.demo.service;

import com.github.pagehelper.PageHelper;
import leib.demo.dao.UserDAO;
import leib.demo.dto.UserDto;
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
    public List<User> findAll(UserDto userDto) {

        PageHelper.startPage(userDto.getPage(), userDto.getSize());
        return userDAO.findAll(userDto) ;
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

    @Override
    public int findTotal() {
        return userDAO.findTotal();
    }
}
