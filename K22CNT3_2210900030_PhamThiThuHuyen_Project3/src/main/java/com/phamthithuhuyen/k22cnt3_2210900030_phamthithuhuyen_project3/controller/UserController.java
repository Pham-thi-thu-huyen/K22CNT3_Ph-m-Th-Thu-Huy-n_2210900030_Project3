package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.UserDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthUser;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Hiển thị danh sách người dùng
    @GetMapping
    public String index(Model model) {
        List<PtthUser> users = userService.getUserList();
        model.addAttribute("list_user", users);
        return "admin/user/index";
    }

    // Hiển thị form tạo mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new UserDTO());
        return "admin/user/create";
    }

    // Lưu người dùng mới
    @PostMapping
    public String save(@ModelAttribute("user") UserDTO userDTO) {
        if (userService.save(userDTO)) {
            return "redirect:/admin/user";
        }
        return "redirect:/admin/user/create?error=true";
    }

    // Hiển thị chi tiết người dùng
    @GetMapping("/show/{id}")
    public String show(Model model, @PathVariable("id") Integer id) {
        PtthUser user = userService.findById(id);
        model.addAttribute("user", user);
        return "admin/user/show";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        PtthUser user = userService.findById(id);
        model.addAttribute("user", user);
        return "admin/user/edit";
    }

    // Cập nhật người dùng
    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("user") UserDTO userDTO) {
        if (userService.update(id, userDTO)) {
            return "redirect:/admin/user";
        }
        return "redirect:/admin/user/edit/" + id + "?error=true";
    }

    // Xóa người dùng
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/admin/user";
    }
}