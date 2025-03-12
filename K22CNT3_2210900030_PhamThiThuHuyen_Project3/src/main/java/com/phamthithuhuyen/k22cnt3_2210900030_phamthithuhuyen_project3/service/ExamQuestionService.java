package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.ExamQuestionDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthExamQuestion;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthExamQuestionId;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.repository.ExamQuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamQuestionService {

    @Autowired
    private ExamQuestionRepository examQuestionRepository;

    // Lấy danh sách tất cả ExamQuestion
    public List<PtthExamQuestion> getExamQuestionList() {
        return examQuestionRepository.findAll();
    }

    // Thêm mới ExamQuestion
    public Boolean save(ExamQuestionDTO examQuestionDTO) {
        try {
            PtthExamQuestion examQuestion = new PtthExamQuestion();
            PtthExamQuestionId id = new PtthExamQuestionId(examQuestionDTO.getExamId(), examQuestionDTO.getQuestionId());
            examQuestion.setId(id);
            examQuestionRepository.save(examQuestion);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Xóa ExamQuestion
    public Boolean delete(PtthExamQuestionId id) {
        if (examQuestionRepository.existsById(id)) {
            examQuestionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Tìm ExamQuestion theo ID
    public PtthExamQuestion findById(PtthExamQuestionId id) {
        return examQuestionRepository.findById(id).orElse(null);
    }

    // Cập nhật ExamQuestion
    public Boolean update(PtthExamQuestionId id, ExamQuestionDTO examQuestionDTO) {
        try {
            PtthExamQuestion examQuestion = findById(id);
            if (examQuestion != null) {
                PtthExamQuestionId newId = new PtthExamQuestionId(examQuestionDTO.getExamId(), examQuestionDTO.getQuestionId());
                examQuestion.setId(newId);
                examQuestionRepository.save(examQuestion);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}