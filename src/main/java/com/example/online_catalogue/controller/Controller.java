package com.example.online_catalogue.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping(value = "/login")
    public ModelAndView login(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }


    @GetMapping(value = "/register")
    public ModelAndView register(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }

    @GetMapping(value = "/recuperare")
    public ModelAndView password(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("password");
        return mav;
    }


}
