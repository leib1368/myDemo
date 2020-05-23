package leib.demo.service;

import leib.demo.entity.User;

import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/5/23 16:30
 */
public interface UserService {
    List<User> findAll ();
    void save(User user);
    void delete(String id);

    void update(User user);
}
