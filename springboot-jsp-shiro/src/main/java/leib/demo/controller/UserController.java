package leib.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:Leib
 * @Date 2020/6/8 22:03
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("logout")
    public String login( ) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return  "redirect:/login.jsp" ;
    }

    @RequestMapping("login")
    public String login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(username, password));
            return "redirect:/index.jsp" ;
        } catch (UnknownAccountException e) {
            e.printStackTrace( );
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e) {
            e.printStackTrace( );
            System.out.println("密码错误");
        }

        return  "redirect:/login.jsp" ;
    }
}
