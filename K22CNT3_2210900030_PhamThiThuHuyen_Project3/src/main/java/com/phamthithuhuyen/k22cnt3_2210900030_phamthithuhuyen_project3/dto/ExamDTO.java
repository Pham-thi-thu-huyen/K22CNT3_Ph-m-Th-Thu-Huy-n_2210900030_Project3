package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
public class ExamDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer examID;
    private String title;
    private String description;
    private Integer createdBy;
    private Instant createdAt;
}