package leib.demo.service;

import leib.demo.entity.User;

import java.util.List;

public interface UserService {

    //模糊搜索
    List<User> findNameOrPhoneCode(String name,String code);

    //修改用户信息方法
    void update(User user);

    //根据id查询用户信息
    User findOne(String id);

    //根据id删除一个用户方法
    void delete(String id);

    //保存用户
    void save(User user);

    //查询所有用户
    List<User> findAll();
}
