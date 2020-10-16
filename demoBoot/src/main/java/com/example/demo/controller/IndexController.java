package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Leib
 * @Date 2020/10/13 19:39
 */
@RestController
public class IndexController {

    @Autowired
    UserService userService;

    @GetMapping(value="/hello/{id}")
    public User findOne(@PathVariable int id) {
        return userService.finById(id);
    }
    @GetMapping("/update")
    public String update() {
        User user = userService.finById(1);
        user.setName("xiaoming");
        userService.update(user);
        return "succeed";
    }
    @GetMapping("/")
    public String hi( ) {
        userService.findAll();
        return "hi";
    }
}
