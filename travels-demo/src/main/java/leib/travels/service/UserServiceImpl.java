package leib.travels.service;

import leib.travels.dao.UserDao;
import leib.travels.enity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:Leib
 * @Date 2020/4/28 22:37
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        User userDB = userDao.findByUsername(user.getUsername());
        if(userDB!=null){
            if(userDB.getPassword().equals(user.getPassword())){
                return userDB;
            }
            throw new RuntimeException("密码输入错误~~~");
        }else{
            throw new RuntimeException("用户名输入错误!!!");
        }
    }

    @Override
    public void register(User user) {
        if (userDao.findByUsername(user.getUsername()) == null) {
            userDao.save(user);
        }else{
            throw new RuntimeException("用户名已经存在~~~~");
        }
    }
}
