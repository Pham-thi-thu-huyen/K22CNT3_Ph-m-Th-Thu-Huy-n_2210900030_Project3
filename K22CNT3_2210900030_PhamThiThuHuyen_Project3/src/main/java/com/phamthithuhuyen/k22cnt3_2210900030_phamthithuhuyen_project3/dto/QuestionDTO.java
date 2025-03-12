package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
public class QuestionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String content;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;
    private Integer createdBy;
    private Instant createdAt;
}