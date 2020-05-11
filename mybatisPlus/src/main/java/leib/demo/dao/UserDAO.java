package leib.demo.dao;

import leib.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

//使用mybatis-plus增强接口
@Repository
public interface UserDAO extends BaseMapper<User> {



}
