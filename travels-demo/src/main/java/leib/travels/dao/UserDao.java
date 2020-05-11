package leib.travels.dao;

import leib.travels.enity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:Leib
 * @Date 2020/4/28 22:34
 */
@Mapper
public interface UserDao {

    User findByUsername(String username);

    void save(User user);
}
