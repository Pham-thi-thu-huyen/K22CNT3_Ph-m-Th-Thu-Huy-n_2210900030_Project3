package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ptth_questions")
public class PtthQuestion {
    @Id
    @Column(name = "QuestionID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "OptionA", nullable = false)
    private String optionA;

    @Column(name = "OptionB", nullable = false)
    private String optionB;

    @Column(name = "OptionC", nullable = false)
    private String optionC;

    @Column(name = "OptionD", nullable = false)
    private String optionD;

    @Lob
    @Column(name = "CorrectOption", nullable = false)
    private String correctOption;

    @Column(name = "CreatedBy", nullable = false)
    private Integer createdBy;

    @ColumnDefault("current_timestamp()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

}