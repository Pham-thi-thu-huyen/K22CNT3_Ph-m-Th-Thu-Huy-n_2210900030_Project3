package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.ExamQuestionDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthExamQuestion;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthExamQuestionId;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service.ExamQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("/admin/exam-question")
public class ExamQuestionController {

    @Autowired
    private ExamQuestionService examQuestionService;

    // Hiển thị danh sách
    @GetMapping
    public String index(Model model) {
        List<PtthExamQuestion> examQuestions = examQuestionService.getExamQuestionList();
        model.addAttribute("list_exam_question", examQuestions);
        return "admin/exam-question/index";
    }

    // Hiển thị form tạo mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("examQuestion", new ExamQuestionDTO());
        return "admin/exam-question/create";
    }

    // Lưu mới
    @PostMapping
    public String save(@ModelAttribute("examQuestion") ExamQuestionDTO examQuestionDTO) {
        if (examQuestionService.save(examQuestionDTO)) {
            return "redirect:/admin/exam-question";
        }
        return "redirect:/admin/exam-question/create?error=true";
    }

    // Hiển thị chi tiết (show)
    @GetMapping("/show/{examId}/{questionId}")
    public String show(Model model, @PathVariable("examId") Integer examId, @PathVariable("questionId") Integer questionId) {
        PtthExamQuestionId id = new PtthExamQuestionId(examId, questionId);
        PtthExamQuestion examQuestion = examQuestionService.findById(id);
        model.addAttribute("examQuestion", examQuestion);
        return "admin/exam-question/show";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{examId}/{questionId}")
    public String edit(Model model, @PathVariable("examId") Integer examId, @PathVariable("questionId") Integer questionId) {
        PtthExamQuestionId id = new PtthExamQuestionId(examId, questionId);
        PtthExamQuestion examQuestion = examQuestionService.findById(id);
        model.addAttribute("examQuestion", examQuestion);
        return "admin/exam-question/edit";
    }

    // Cập nhật
    @PostMapping("/edit/{examId}/{questionId}")
    public String update(@PathVariable("examId") Integer examId, @PathVariable("questionId") Integer questionId,
                         @ModelAttribute("examQuestion") ExamQuestionDTO examQuestionDTO) {
        PtthExamQuestionId id = new PtthExamQuestionId(examId, questionId);
        if (examQuestionService.update(id, examQuestionDTO)) {
            return "redirect:/admin/exam-question";
        }
        return "redirect:/admin/exam-question/edit/" + examId + "/" + questionId + "?error=true";
    }

    // Xóa
    @GetMapping("/delete/{examId}/{questionId}")
    public String delete(@PathVariable("examId") Integer examId, @PathVariable("questionId") Integer questionId) {
        PtthExamQuestionId id = new PtthExamQuestionId(examId, questionId);
        examQuestionService.delete(id);
        return "redirect:/admin/exam-question";
    }
}