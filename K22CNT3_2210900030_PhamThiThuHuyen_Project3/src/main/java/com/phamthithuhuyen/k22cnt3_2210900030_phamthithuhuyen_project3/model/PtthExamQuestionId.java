package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PtthExamQuestionId implements java.io.Serializable {
    private static final long serialVersionUID = 8515341712144288237L;
    @Column(name = "ExamID", nullable = false)
    private Integer examID;

    @Column(name = "QuestionID", nullable = false)
    private Integer questionID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PtthExamQuestionId entity = (PtthExamQuestionId) o;
        return Objects.equals(this.questionID, entity.questionID) &&
                Objects.equals(this.examID, entity.examID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionID, examID);
    }

}