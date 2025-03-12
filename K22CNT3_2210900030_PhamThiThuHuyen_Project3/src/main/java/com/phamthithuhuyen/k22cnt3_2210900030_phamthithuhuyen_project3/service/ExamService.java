package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.ExamDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthExam;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.repository.ExamRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    // Lấy danh sách tất cả bài thi
    public List<PtthExam> getExamList() {
        return examRepository.findAll();
    }

    // Thêm mới bài thi
    public Boolean save(ExamDTO examDTO) {
        try {
            PtthExam exam = new PtthExam();
            BeanUtils.copyProperties(examDTO, exam);
            examRepository.save(exam); // createdAt sẽ được gán tự động bởi @PrePersist
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Xóa bài thi
    public Boolean delete(Integer id) {
        if (examRepository.existsById(id)) {
            examRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Tìm bài thi theo ID
    public PtthExam findById(Integer id) {
        return examRepository.findById(id).orElse(null);
    }

    // Cập nhật bài thi
    public Boolean update(Integer id, ExamDTO examDTO) {
        try {
            PtthExam exam = findById(id);
            if (exam != null) {
                BeanUtils.copyProperties(examDTO, exam);
                exam.setExamID(id); // Đảm bảo ID không bị thay đổi
                examRepository.save(exam);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}