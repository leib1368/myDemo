package leib.shiro.service;

import leib.shiro.entity.User;

/**
 * @Author:Leib
 * @Date 2020/5/7 15:09
 */
public interface UserService {
    public User queryByName(String name);
}

