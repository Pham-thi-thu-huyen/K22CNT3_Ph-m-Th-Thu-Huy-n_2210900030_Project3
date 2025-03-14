package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.UserDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthUser;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Inject BCryptPasswordEncoder

    // Lấy danh sách tất cả người dùng
    public List<PtthUser> getUserList() {
        return userRepository.findAll();
    }

    // Thêm mới người dùng
    public Boolean save(UserDTO userDTO) {
        try {
            PtthUser user = new PtthUser();
            BeanUtils.copyProperties(userDTO, user);
            // Mã hóa mật khẩu trước khi lưu
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Xóa người dùng
    public Boolean delete(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Tìm người dùng theo ID
    public PtthUser findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    // Cập nhật người dùng
    public Boolean update(Integer id, UserDTO userDTO) {
        try {
            PtthUser user = findById(id);
            if (user != null) {
                BeanUtils.copyProperties(userDTO, user);
                user.setId(id); // Đảm bảo ID không bị thay đổi
                // Mã hóa mật khẩu nếu có thay đổi
                if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
                    user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
                }
                userRepository.save(user);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}