package com.example.je_lab4.repositories.clientAttributes;

import com.example.je_lab4.data.Hobby;
import com.example.je_lab4.model.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharactersRepository extends JpaRepository<Hobby, Integer> {
    @Query(value = """ 
    SELECT
	CH.ID,
	CH.Trait
FROM characters CH
""", nativeQuery = true)
    List<Characters> getTraitsList();
}
