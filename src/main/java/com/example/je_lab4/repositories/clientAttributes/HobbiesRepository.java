package com.example.je_lab4.repositories.clientAttributes;

import com.example.je_lab4.data.Hobby;
import com.example.je_lab4.model.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HobbiesRepository extends JpaRepository<Hobby, Integer> {
    @Query(value = """ 
    SELECT
	H.ID,
	H.Hobby
FROM hobbies H
""", nativeQuery = true)
    List<Hobbies> getHobbyList();
}
