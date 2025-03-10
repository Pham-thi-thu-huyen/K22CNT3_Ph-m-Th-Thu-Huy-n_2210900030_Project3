package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ptth_submission_answers")
public class PtthSubmissionAnswer {
    @EmbeddedId
    private PtthSubmissionAnswerId id;

    @Lob
    @Column(name = "selectedOption", nullable = false)
    private String selectedOption;

}