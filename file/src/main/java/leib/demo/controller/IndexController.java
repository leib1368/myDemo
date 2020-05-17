package leib.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author:Leib
 * @Date 2020/5/16 21:15
 */

@Controller
public class IndexController {


    @GetMapping("index")
    public String toLogin(){
        return "login";
    }

}