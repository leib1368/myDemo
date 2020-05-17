package leib.demo.controller;

import leib.demo.entity.User;
import leib.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author:Leib
 * @Date 2020/5/16 21:16
 */
@Controller
@RequestMapping("user")
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 登录方法
     */
    @PostMapping("login")
    public String login(User user, HttpSession session){
        User userDB = userService.login(user);
        if(userDB!=null){
            session.setAttribute("user",userDB);
            return "redirect:/file/showAll";
        }else{
            return "redirect:/index";
        }
    }

}
