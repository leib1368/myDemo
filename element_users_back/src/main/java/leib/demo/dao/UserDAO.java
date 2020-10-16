package leib.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import leib.demo.dto.UserDto;
import leib.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/5/23 16:20
 */
@Mapper
@Repository
public interface UserDAO extends BaseMapper<User> {
    List<User> findAll (UserDto userDto);

    void save(User user);

    void delete(String id);

    void update(User user);


    int findTotal();
}
