package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.controller;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthUser;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.Role;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class AuthController {

    @Autowired
    private UserRepository nguoiDungRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return "home/login";
    }

    @GetMapping("/signup")
    public String registerPage() {
        return "home/signup";
    }

    @PostMapping("/register")
    public String register(@RequestParam("email") String email,
                           @RequestParam("password") String password,
                           @RequestParam("fullName") String fullName,
                           Model model) {
        // Kiểm tra xem email đã tồn tại chưa
        if (nguoiDungRepository.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
            return "home/signup";
        }

        // Tạo người dùng mới
        PtthUser nguoidung = new PtthUser();
        nguoidung.setFullName(fullName);
        nguoidung.setEmail(email);
        nguoidung.setPassword(passwordEncoder.encode(password)); // Mã hóa mật khẩu
        nguoidung.setRole(Role.STUDENT); // Mặc định là STUDENT

        // Lưu vào database
        nguoiDungRepository.save(nguoidung);

        // Đăng nhập tự động
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                email,
                password,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + nguoidung.getRole().name()))
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Chuyển hướng thủ công
        if (nguoidung.getRole() == Role.TEACHER) {
            return "redirect:/admin";
        } else {
            return "redirect:/";
        }
    }

    // Thêm endpoint kiểm tra thủ công
    @PostMapping("/manual-login")
    public String manualLogin(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              Model model) {
        // Tìm người dùng trong database
        PtthUser nguoidung = nguoiDungRepository.findByEmail(email)
                .orElse(null);

        // Kiểm tra xem người dùng có tồn tại không
        if (nguoidung == null) {
            model.addAttribute("error", "Tên đăng nhập không tồn tại!");
            return "home/login"; // Trả về trang login với thông báo lỗi
        }

        // So sánh mật khẩu plaintext với mật khẩu mã hóa trong database
        if (!passwordEncoder.matches(password, nguoidung.getPassword())) {
            model.addAttribute("error", "Mật khẩu không đúng!");
            return "home/login"; // Trả về trang login với thông báo lỗi
        }

        // Nếu xác thực thành công, thiết lập phiên đăng nhập
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                nguoidung.getUsername(),
                nguoidung.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+nguoidung.getRole().name()))
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Chuyển hướng dựa trên vai trò
        if (nguoidung.getRole() == Role.TEACHER) {
            return "redirect:/admin";
        } else {
            return "redirect:/";
        }
    }
}