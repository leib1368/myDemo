package leib.shiro.mapper;

import leib.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author:Leib
 * @Date 2020/5/7 15:04
 */
@Repository
@Mapper
public interface UserMapper {
    public User queryByName(String name );
}
