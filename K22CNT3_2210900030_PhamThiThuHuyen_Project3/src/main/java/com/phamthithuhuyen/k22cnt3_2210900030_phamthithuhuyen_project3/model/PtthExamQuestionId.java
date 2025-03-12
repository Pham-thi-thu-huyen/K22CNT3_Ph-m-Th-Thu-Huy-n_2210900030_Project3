package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PtthExamQuestionId implements Serializable {
    private Integer examId;
    private Integer questionId;

    // Constructors
    public PtthExamQuestionId() {}

    public PtthExamQuestionId(Integer examId, Integer questionId) {
        this.examId = examId;
        this.questionId = questionId;
    }

    // Equals và HashCode để đảm bảo composite key hoạt động đúng
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PtthExamQuestionId that = (PtthExamQuestionId) o;
        return Objects.equals(examId, that.examId) && Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId, questionId);
    }
}