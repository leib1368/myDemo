package com.leib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:Leib
 * @Date 2020/10/15 14:47
 */

@Controller
public class controller {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
