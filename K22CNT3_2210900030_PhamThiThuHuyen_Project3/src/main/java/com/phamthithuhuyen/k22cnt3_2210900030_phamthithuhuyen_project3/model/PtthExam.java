package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
@Data
@Entity
@Table(name = "ptth_exam")
public class PtthExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Thêm @GeneratedValue nếu ID tự động tăng
    @Column(name = "ExamID", nullable = false)
    private Integer examID;

    public Integer getExamID() {
        return examID;
    }

    public void setExamID(Integer examID) {
        this.examID = examID;
    }

    @Column(name = "Title", nullable = false)
    private String title;

    @Lob
    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "CreatedBy", nullable = false)
    private Integer createdBy;

    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private Instant createdAt;

    // Gán giá trị mặc định cho CreatedAt trước khi lưu vào database
    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }


}


