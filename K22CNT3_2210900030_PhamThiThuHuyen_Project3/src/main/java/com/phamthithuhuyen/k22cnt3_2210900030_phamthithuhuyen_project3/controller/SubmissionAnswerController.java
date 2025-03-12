package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.SubmissionAnswerDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthSubmissionAnswer;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthSubmissionAnswerId;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service.SubmissionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("/admin/submission-answer")
public class SubmissionAnswerController {

    @Autowired
    private SubmissionAnswerService submissionAnswerService;

    // Hiển thị danh sách
    @GetMapping
    public String index(Model model) {
        List<PtthSubmissionAnswer> submissionAnswers = submissionAnswerService.getSubmissionAnswerList();
        model.addAttribute("list_submission_answer", submissionAnswers);
        return "admin/submission-answer/index";
    }

    // Hiển thị form tạo mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("submissionAnswer", new SubmissionAnswerDTO());
        return "admin/submission-answer/create";
    }

    // Lưu mới
    @PostMapping
    public String save(@ModelAttribute("submissionAnswer") SubmissionAnswerDTO submissionAnswerDTO) {
        if (submissionAnswerService.save(submissionAnswerDTO)) {
            return "redirect:/admin/submission-answer";
        }
        return "redirect:/admin/submission-answer/create?error=true";
    }

    // Hiển thị chi tiết (show)
    @GetMapping("/show/{submissionID}/{questionID}")
    public String show(Model model, @PathVariable("submissionID") Integer submissionID, @PathVariable("questionID") Integer questionID) {
        PtthSubmissionAnswerId id = new PtthSubmissionAnswerId();
        id.setSubmissionID(submissionID);
        id.setQuestionID(questionID);
        PtthSubmissionAnswer submissionAnswer = submissionAnswerService.findById(id);
        model.addAttribute("submissionAnswer", submissionAnswer);
        return "admin/submission-answer/show";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{submissionID}/{questionID}")
    public String edit(Model model, @PathVariable("submissionID") Integer submissionID, @PathVariable("questionID") Integer questionID) {
        PtthSubmissionAnswerId id = new PtthSubmissionAnswerId();
        id.setSubmissionID(submissionID);
        id.setQuestionID(questionID);
        PtthSubmissionAnswer submissionAnswer = submissionAnswerService.findById(id);
        model.addAttribute("submissionAnswer", submissionAnswer);
        return "admin/submission-answer/edit";
    }

    // Cập nhật
    @PostMapping("/edit/{submissionID}/{questionID}")
    public String update(@PathVariable("submissionID") Integer submissionID, @PathVariable("questionID") Integer questionID,
                         @ModelAttribute("submissionAnswer") SubmissionAnswerDTO submissionAnswerDTO) {
        PtthSubmissionAnswerId id = new PtthSubmissionAnswerId();
        id.setSubmissionID(submissionID);
        id.setQuestionID(questionID);
        if (submissionAnswerService.update(id, submissionAnswerDTO)) {
            return "redirect:/admin/submission-answer";
        }
        return "redirect:/admin/submission-answer/edit/" + submissionID + "/" + questionID + "?error=true";
    }

    // Xóa
    @GetMapping("/delete/{submissionID}/{questionID}")
    public String delete(@PathVariable("submissionID") Integer submissionID, @PathVariable("questionID") Integer questionID) {
        PtthSubmissionAnswerId id = new PtthSubmissionAnswerId();
        id.setSubmissionID(submissionID);
        id.setQuestionID(questionID);
        submissionAnswerService.delete(id);
        return "redirect:/admin/submission-answer";
    }
}