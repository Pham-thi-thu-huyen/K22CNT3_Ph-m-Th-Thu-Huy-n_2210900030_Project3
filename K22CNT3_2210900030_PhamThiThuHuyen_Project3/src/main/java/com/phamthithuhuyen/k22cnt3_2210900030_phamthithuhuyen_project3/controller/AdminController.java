package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/admin")
    public  String admin(){
        return "admin/index";
    }
}
