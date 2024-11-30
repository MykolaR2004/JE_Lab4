package com.example.je_lab4.repositories.clientAttributes;

import com.example.je_lab4.data.Hobby;
import com.example.je_lab4.model.Hobbies;
import com.example.je_lab4.model.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequirementsRepository extends JpaRepository<Hobby, Integer> {
    @Query(value = """ 
    SELECT
	R.ID,
	R.requirement
FROM requirements R
""", nativeQuery = true)
    List<Requirements> getRequirementsList();
}
