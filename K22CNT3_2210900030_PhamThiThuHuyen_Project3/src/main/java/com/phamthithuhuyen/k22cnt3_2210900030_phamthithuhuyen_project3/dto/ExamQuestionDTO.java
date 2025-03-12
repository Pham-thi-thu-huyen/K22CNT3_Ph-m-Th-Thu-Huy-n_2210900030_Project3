package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ExamQuestionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer examId;
    private Integer questionId;
}