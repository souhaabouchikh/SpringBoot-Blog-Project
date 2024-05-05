package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoutesController {
    @RequestMapping("/Contact")
    public String Contact(){
        return "Contact";
    }
//    @RequestMapping(value = {"/Index", "/"})
//    public String index(){
//        return "index";
//    }
//    @RequestMapping("/Post")
//    public String post(){
//        return "post";
//    }
    @RequestMapping("/About")
    public String About(){
        return "About";
    }
}
