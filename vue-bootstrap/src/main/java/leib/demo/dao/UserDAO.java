package leib.demo.dao;

import leib.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {


    //根据姓名或者电话进行模糊搜索
    List<User> findNameOrPhoneCode(@Param("name") String name, @Param("code") String phoneCode);

    //根据id修改用户信息
    void update(User user);

    //根据id查询一个信息
    User findOne(String id);

    //根据id删除用户信息
    void delete(String id);

    //查询所有
    List<User> findAll();

    //保存用户方法
    void save(User user);
}


