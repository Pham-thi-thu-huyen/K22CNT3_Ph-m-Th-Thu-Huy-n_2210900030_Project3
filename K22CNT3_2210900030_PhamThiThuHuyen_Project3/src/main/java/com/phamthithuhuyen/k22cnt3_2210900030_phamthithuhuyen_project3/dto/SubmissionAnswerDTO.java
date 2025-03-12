package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SubmissionAnswerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer submissionID;
    private Integer questionID;
    private String answer;
}