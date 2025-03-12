package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.SubmissionDTO;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthSubmission;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.repository.SubmissionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    public List<PtthSubmission> getSubmissionList() {
        return submissionRepository.findAll();
    }

    public Boolean save(SubmissionDTO submissionDTO) {
        try {
            PtthSubmission submission = new PtthSubmission();
            BeanUtils.copyProperties(submissionDTO, submission, "submittedAt"); // Bỏ qua submittedAt
            submissionRepository.save(submission); // @PrePersist sẽ gán submittedAt
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(Integer id) {
        if (submissionRepository.existsById(id)) {
            submissionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public PtthSubmission findById(Integer id) {
        return submissionRepository.findById(id).orElse(null);
    }

    public Boolean update(Integer id, SubmissionDTO submissionDTO) {
        try {
            PtthSubmission submission = findById(id);
            if (submission != null) {
                BeanUtils.copyProperties(submissionDTO, submission, "submittedAt"); // Giữ nguyên submittedAt cũ
                submission.setId(id);
                submissionRepository.save(submission);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}