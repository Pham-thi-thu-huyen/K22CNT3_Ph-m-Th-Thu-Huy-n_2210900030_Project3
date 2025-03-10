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
public class PtthSubmissionAnswerId implements java.io.Serializable {
    private static final long serialVersionUID = 6468307712395175399L;
    @Column(name = "SubmissionID", nullable = false)
    private Integer submissionID;

    @Column(name = "QuestionID", nullable = false)
    private Integer questionID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PtthSubmissionAnswerId entity = (PtthSubmissionAnswerId) o;
        return Objects.equals(this.submissionID, entity.submissionID) &&
                Objects.equals(this.questionID, entity.questionID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submissionID, questionID);
    }

}