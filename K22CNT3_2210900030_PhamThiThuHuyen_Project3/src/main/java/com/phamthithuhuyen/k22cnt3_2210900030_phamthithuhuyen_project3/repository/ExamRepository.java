package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.repository;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<PtthExam, Integer> {
}