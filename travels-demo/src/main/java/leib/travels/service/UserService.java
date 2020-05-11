package leib.travels.service;

import leib.travels.enity.User;

/**
 * @Author:Leib
 * @Date 2020/4/28 22:36
 */
public interface UserService {
    User login(User user);

    void register(User user);
}
