package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.QuestionDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthQuestion;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.repository.QuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    // Lấy danh sách tất cả câu hỏi
    public List<PtthQuestion> getQuestionList() {
        return questionRepository.findAll();
    }

    // Thêm mới câu hỏi
    public Boolean save(QuestionDTO questionDTO) {
        try {
            PtthQuestion question = new PtthQuestion();
            BeanUtils.copyProperties(questionDTO, question);
            // Đảm bảo createdAt luôn có giá trị
            question.setCreatedAt(Instant.now());
            questionRepository.save(question);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi để debug
            return false;
        }
    }

    // Xóa câu hỏi
    public Boolean delete(Integer id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Tìm câu hỏi theo ID
    public PtthQuestion findById(Integer id) {
        return questionRepository.findById(id).orElse(null);
    }

    // Cập nhật câu hỏi
    public Boolean update(Integer id, QuestionDTO questionDTO) {
        try {
            PtthQuestion question = findById(id);
            if (question != null) {
                // Lưu giá trị createdAt cũ trước khi copy
                Instant originalCreatedAt = question.getCreatedAt();
                BeanUtils.copyProperties(questionDTO, question);
                question.setId(id); // Đảm bảo ID không bị thay đổi
                // Khôi phục createdAt để không bị null
                question.setCreatedAt(originalCreatedAt);
                questionRepository.save(question);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi để debug
            return false;
        }
    }
}