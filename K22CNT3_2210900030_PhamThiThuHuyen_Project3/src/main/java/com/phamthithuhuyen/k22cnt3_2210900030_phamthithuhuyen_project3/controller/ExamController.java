package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.ExamDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthExam;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service.ExamService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("admin/exam")  // Định nghĩa đường dẫn gốc
public class ExamController {
  @Autowired
  private ExamService examService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("list_exam", examService.getExamList()); // Truyền dữ liệu ra view
        return "admin/exam/index"; // Trả về view "admin/exam/index.html"
    }

    @GetMapping("/create")
    public String create(Model model) {
        PtthExam ptthExam = new PtthExam();
        model.addAttribute("exam", ptthExam);
        return "admin/exam/create"; // Trả về trang tạo mới bài thi
    }

    @PostMapping
    public String save(@ModelAttribute("exam") ExamDTO examDTO) {
        if(examService.save(examDTO)){
            return "redirect:/admin/exam";
        }
        return "redirect:/admin/exam/create?error=true";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @Validated @PathVariable("id") Integer id) {
        PtthExam ptthExam = examService.findById(id);
        model.addAttribute("exam", ptthExam);
        return "admin/exam/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Validated @NotNull @PathVariable("id") Integer id,
                       @Validated @RequestBody ExamDTO examDTO) {
        examService.update(id, examDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@Validated @NotNull @PathVariable("id") Integer id) {
        examService.delete(id);
    }

}
