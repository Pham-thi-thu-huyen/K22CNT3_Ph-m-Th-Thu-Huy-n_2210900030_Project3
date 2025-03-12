package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.SubmissionAnswerDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthSubmissionAnswer;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthSubmissionAnswerId;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.repository.SubmissionAnswerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionAnswerService {

    @Autowired
    private SubmissionAnswerRepository submissionAnswerRepository;

    // Lấy danh sách tất cả câu trả lời
    public List<PtthSubmissionAnswer> getSubmissionAnswerList() {
        return submissionAnswerRepository.findAll();
    }

    // Thêm mới câu trả lời
    public Boolean save(SubmissionAnswerDTO submissionAnswerDTO) {
        try {
            PtthSubmissionAnswer submissionAnswer = new PtthSubmissionAnswer();
            PtthSubmissionAnswerId id = new PtthSubmissionAnswerId();
            id.setSubmissionID(submissionAnswerDTO.getSubmissionID());
            id.setQuestionID(submissionAnswerDTO.getQuestionID());
            submissionAnswer.setId(id);
            submissionAnswer.setAnswer(submissionAnswerDTO.getAnswer());
            submissionAnswerRepository.save(submissionAnswer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Xóa câu trả lời
    public Boolean delete(PtthSubmissionAnswerId id) {
        if (submissionAnswerRepository.existsById(id)) {
            submissionAnswerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Tìm câu trả lời theo ID
    public PtthSubmissionAnswer findById(PtthSubmissionAnswerId id) {
        return submissionAnswerRepository.findById(id).orElse(null);
    }

    // Cập nhật câu trả lời
    public Boolean update(PtthSubmissionAnswerId id, SubmissionAnswerDTO submissionAnswerDTO) {
        try {
            PtthSubmissionAnswer submissionAnswer = findById(id);
            if (submissionAnswer != null) {
                PtthSubmissionAnswerId newId = new PtthSubmissionAnswerId();
                newId.setSubmissionID(submissionAnswerDTO.getSubmissionID());
                newId.setQuestionID(submissionAnswerDTO.getQuestionID());
                submissionAnswer.setId(newId);
                submissionAnswer.setAnswer(submissionAnswerDTO.getAnswer());
                submissionAnswerRepository.save(submissionAnswer);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}