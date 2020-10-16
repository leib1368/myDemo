package leib.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:Leib
 * @Date 2020/10/15 15:03
 */
@Controller
public class myController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    @ResponseBody
    public String succ() {
        return "succ";
    }
}
