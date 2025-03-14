package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.ExamDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthExam;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("/admin/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    // Hiển thị danh sách kỳ thi
    @GetMapping
    public String index(Model model) {
        List<PtthExam> exams = examService.getExamList();
        model.addAttribute("list_exam", exams);
        return "admin/exam/index";
    }

    // Hiển thị form tạo mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("exam", new ExamDTO());
        return "admin/exam/create";
    }

    // Lưu kỳ thi mới
    @PostMapping
    public String save(@ModelAttribute("exam") ExamDTO examDTO) {
        if (examService.save(examDTO)) {
            return "redirect:/admin/exam";
        }
        return "redirect:/admin/exam/create?error=true";
    }

    // Hiển thị chi tiết kỳ thi
    @GetMapping("/show/{id}")
    public String show(Model model, @PathVariable("id") Integer id) {
        PtthExam exam = examService.findById(id);
        model.addAttribute("exam", exam);
        return "admin/exam/show";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        PtthExam exam = examService.findById(id);
        model.addAttribute("exam", exam);
        return "admin/exam/edit";
    }

    // Cập nhật kỳ thi
    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("exam") ExamDTO examDTO) {
        if (examService.update(id, examDTO)) {
            return "redirect:/admin/exam";
        }
        return "redirect:/admin/exam/edit/" + id + "?error=true";
    }

    // Xóa kỳ thi
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        examService.delete(id);
        return "redirect:/admin/exam";
    }
}