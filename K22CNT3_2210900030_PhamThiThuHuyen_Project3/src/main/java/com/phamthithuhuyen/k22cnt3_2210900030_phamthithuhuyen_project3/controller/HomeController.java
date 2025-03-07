package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("index")
    public String index() {
        return "index";
    }
    @RequestMapping("404")
    public String _404(){
        return "404";
    }
    @RequestMapping ("about")
    public String about (){
        return "about";
    }
    @RequestMapping("contact")
    public String contact (){
        return "contact";
    }
   @RequestMapping("courses")
   public String courses (){
        return "courses";
   }
    @RequestMapping("team")
    public String team (){
        return "team";
    }
    @RequestMapping("testimonial")
    public String testimonial (){
        return "testimonial";
    }
    @RequestMapping("login")
    public String login (){
        return "login";
    }
    @RequestMapping("signup")
    public String signup (){
        return "signup";
    }
}