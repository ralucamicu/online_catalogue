package com.example.online_catalogue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

    @ResponseBody
    @GetMapping("/adminPage")
        public String adminPage(){
            return "Admin page";
        }

}
