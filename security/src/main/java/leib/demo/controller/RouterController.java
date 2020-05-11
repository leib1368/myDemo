package leib.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:Leib
 * @Date 2020/5/7 10:56
 */
@Controller
public class RouterController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
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
}
