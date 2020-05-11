package leib.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:Leib
 * @Date 2020/5/7 13:31
 */
@Controller
public class IndexController {
    @RequestMapping({"/","index"})
    public String Index(Model model){
        model.addAttribute("msg","hi,~~~");
        return "index";
    }

    @RequestMapping("/login")
    public String login (String username,String password,Model model){
        //封装当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //执行登录方法
        try {
            subject.login(token);
            return "index" ;
        } catch (UnknownAccountException e) {
            //用户名不存在
            model.addAttribute("msg","用户名错误");
            return "views/login";
        } catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "views/login";
        }

    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "views/login";
    }

    @RequestMapping("/level1/{id}")
    public String leve1(@PathVariable("id") int id ){
        return "views/level1/"+id;
    }

    @RequestMapping("/level2/{id}")
    public String leve2(@PathVariable("id") int id ){
        return "views/level2/"+id;
    }

    @RequestMapping("/level3/{id}")
    public String leve3(@PathVariable("id") int id ){
        return "views/level3/"+id;
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String unauth(){
        return "未授权访问" ;
    }
}
