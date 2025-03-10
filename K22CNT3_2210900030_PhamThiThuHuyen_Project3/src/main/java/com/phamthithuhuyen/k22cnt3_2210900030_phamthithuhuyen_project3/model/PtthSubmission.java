package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ptth_submissions")
public class PtthSubmission {
    @Id
    @Column(name = "SubmissionID", nullable = false)
    private Integer id;

    @Column(name = "ExamID", nullable = false)
    private Integer examID;

    @Column(name = "UserID", nullable = false)
    private Integer userID;

    @Column(name = "Score", nullable = false)
    private Float score;

    @ColumnDefault("current_timestamp()")
    @Column(name = "SubmittedAt", nullable = false)
    private Instant submittedAt;

}