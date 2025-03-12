package com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.repository;

import com.phamthithuhuyen.k22cnt3_2210900030_phamthithuhuyen_project3.model.PtthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;


public interface UserRepository extends JpaRepository<PtthUser, Integer>,JpaSpecificationExecutor<PtthUser> {
    Optional<PtthUser> findByEmail(String email);
}
