package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Leib
 * @Date 2020/10/13 19:35
 */
@Mapper
@Repository
public interface UserDAO {

    void save(User user);

    void update(User user);

    void delete(String id);

    List<User> findAll();

    User finById(int id);
}

