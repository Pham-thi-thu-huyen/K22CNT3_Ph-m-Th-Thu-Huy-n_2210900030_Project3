package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

@Validated
@Controller("admin/exam")
public class ExamController {
    @GetMapping
    public String index() {
        return "admin/exam/index";

    }
}
