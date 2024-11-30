package com.example.je_lab4.repositories;

import com.example.je_lab4.data.DatingTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;


public interface DateRepository extends JpaRepository<DatingTable, Integer> {
    @Modifying
    @Query(value = """ 
            INSERT INTO `meeting_agency`.`dating_table` (`User_1_ID`, `User_2_ID`, `Date`, `Registration_country`)
VALUES (?1, ?2, ?3, ?4);
""", nativeQuery = true)
    void getDateList(int firstid, int secondid, LocalDateTime date, int country);

}