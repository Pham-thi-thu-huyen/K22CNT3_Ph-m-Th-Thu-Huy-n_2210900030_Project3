package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "home/index";
    }
    @RequestMapping("404")
    public String _404(){
        return "home/404";
    }
    @RequestMapping ("about")
    public String about (){
        return "home/about";
    }
    @RequestMapping("contact")
    public String contact (){
        return "home/contact";
    }
   @RequestMapping("courses")
   public String courses (){
        return "home/courses";
   }
    @RequestMapping("team")
    public String team (){
        return "home/team";
    }
    @RequestMapping("testimonial")
    public String testimonial (){
        return "home/testimonial";
    }
    @RequestMapping("login")
    public String login (){
        return "home/login";
    }
    @RequestMapping("signup")
    public String signup (){
        return "home/signup";
    }
}