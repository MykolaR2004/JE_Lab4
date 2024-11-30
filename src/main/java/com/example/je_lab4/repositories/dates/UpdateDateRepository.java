package com.example.je_lab4.repositories.dates;

import com.example.je_lab4.data.DatingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface UpdateDateRepository extends JpaRepository<DatingTable, Integer> {
    @Transactional
    @Modifying
    @Query(value = """ 
        UPDATE `dating_table` SET `Date` = ?2 WHERE `id` = ?1;
""", nativeQuery = true)
    void updateDate(int dateId, LocalDateTime date);
}
