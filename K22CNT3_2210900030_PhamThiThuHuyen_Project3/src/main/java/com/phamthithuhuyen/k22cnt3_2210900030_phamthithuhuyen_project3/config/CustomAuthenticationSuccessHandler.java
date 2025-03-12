package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // Lấy danh sách vai trò của người dùng
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();
            // Chuyển hướng dựa trên vai trò
            if (role.equals("ROLE_TEACHER")) {
                response.sendRedirect("/admin");
                return;
            } else if (role.equals("ROLE_STUDENT")) {
                response.sendRedirect("/");
                return;
            }
        }
        // Mặc định chuyển về trang chủ nếu không có vai trò nào khớp
        response.sendRedirect("/");
    }
}