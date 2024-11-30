package com.example.je_lab4.repositories.dates;

import com.example.je_lab4.data.DatingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface NewDateRepository extends JpaRepository<DatingTable, Integer> {

    @Modifying
    @Transactional
    @Query(value = """ 
            INSERT INTO dating_table (`User_1_ID`, `User_2_ID`, `Date`, `Registration_country`)
VALUES (?1, ?2, ?3, ?4);
""", nativeQuery = true)
    void getDateList(int firstid, int secondid, LocalDateTime date, int country);


}