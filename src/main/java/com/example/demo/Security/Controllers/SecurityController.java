package com.example.demo.Security.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

//    @GetMapping("/AdminHome")
//    public String AdminHome() {
//        return "redirect:/CategoryPanel";
//    }
//
     @GetMapping("/Access_Denied")
    public String AdminHome() {
        return "Access_Denied";
    }
}
