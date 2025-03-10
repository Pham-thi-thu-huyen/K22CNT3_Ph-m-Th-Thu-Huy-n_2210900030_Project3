package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.service;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthExam;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.repository.ExamRepository;
import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto.ExamDTO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;


    public List<PtthExam> getExamList(){
        return examRepository.findAll();
    }

    public Boolean save(ExamDTO examDTO) {
        try {
            PtthExam bean = new PtthExam();
            BeanUtils.copyProperties(examDTO, bean);
            examRepository.save(bean);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public Boolean delete(Integer id) {
        if (examRepository.existsById(id)) {
            examRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Boolean update(Integer id, ExamDTO examDTO) {
        try {
            PtthExam bean = findById(id);
            if (bean == null) {
                return false; // Không tìm thấy exam
            }
            BeanUtils.copyProperties(examDTO, bean);
            examRepository.save(bean);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public PtthExam findById(Integer id) {
        return examRepository.findById(id).get();
    }
}