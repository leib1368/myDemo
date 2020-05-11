package leib.demo.service;


import leib.demo.entity.User;

import java.util.List;

public interface UserService{


    List<User> findAll();

    void save(User user);

}
