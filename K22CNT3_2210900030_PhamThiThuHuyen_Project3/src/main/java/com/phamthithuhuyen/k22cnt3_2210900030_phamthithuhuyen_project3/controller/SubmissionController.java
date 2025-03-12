package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.SubmissionDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthSubmission;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("/admin/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    // Hiển thị danh sách bài nộp
    @GetMapping
    public String index(Model model) {
        List<PtthSubmission> submissions = submissionService.getSubmissionList();
        model.addAttribute("list_submission", submissions);
        return "admin/submission/index";
    }

    // Hiển thị form tạo mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("submission", new SubmissionDTO());
        return "admin/submission/create";
    }

    // Lưu bài nộp mới
    @PostMapping
    public String save(@ModelAttribute("submission") SubmissionDTO submissionDTO) {
        if (submissionService.save(submissionDTO)) {
            return "redirect:/admin/submission";
        }
        return "redirect:/admin/submission/create?error=true";
    }

    // Hiển thị chi tiết bài nộp (show)
    @GetMapping("/show/{id}")
    public String show(Model model, @PathVariable("id") Integer id) {
        PtthSubmission submission = submissionService.findById(id);
        model.addAttribute("submission", submission);
        return "admin/submission/show";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        PtthSubmission submission = submissionService.findById(id);
        model.addAttribute("submission", submission);
        return "admin/submission/edit";
    }

    // Cập nhật bài nộp
    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("submission") SubmissionDTO submissionDTO) {
        if (submissionService.update(id, submissionDTO)) {
            return "redirect:/admin/submission";
        }
        return "redirect:/admin/submission/edit/" + id + "?error=true";
    }

    // Xóa bài nộp
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        submissionService.delete(id);
        return "redirect:/admin/submission";
    }
}