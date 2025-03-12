package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.QuestionDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthQuestion;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("/admin/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Hiển thị danh sách câu hỏi
    @GetMapping
    public String index(Model model) {
        List<PtthQuestion> questions = questionService.getQuestionList();
        model.addAttribute("list_question", questions);
        return "admin/question/index";
    }

    // Hiển thị form tạo mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("question", new QuestionDTO());
        return "admin/question/create";
    }

    // Lưu câu hỏi mới
    @PostMapping
    public String save(@ModelAttribute("question") QuestionDTO questionDTO) {
        if (questionService.save(questionDTO)) {
            return "redirect:/admin/question";
        }
        return "redirect:/admin/question/create?error=true";
    }

    // Hiển thị chi tiết câu hỏi (show)
    @GetMapping("/show/{id}")
    public String show(Model model, @PathVariable("id") Integer id) {
        PtthQuestion question = questionService.findById(id);
        model.addAttribute("question", question);
        return "admin/question/show";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        PtthQuestion question = questionService.findById(id);
        model.addAttribute("question", question);
        return "admin/question/edit";
    }

    // Cập nhật câu hỏi
    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("question") QuestionDTO questionDTO) {
        if (questionService.update(id, questionDTO)) {
            return "redirect:/admin/question";
        }
        return "redirect:/admin/question/edit/" + id + "?error=true";
    }

    // Xóa câu hỏi
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        questionService.delete(id);
        return "redirect:/admin/question";
    }
}