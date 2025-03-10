package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.dto;

import jakarta.persistence.PrePersist;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class ExamDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer examID;
    private String title;
    private String description;
    private Integer createdBy;
    private Instant createdAt;

    // Gán giá trị mặc định cho CreatedAt trước khi lưu vào database
    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }
}
