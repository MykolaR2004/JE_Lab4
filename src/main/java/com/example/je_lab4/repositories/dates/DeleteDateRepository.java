package com.example.je_lab4.repositories.dates;

import com.example.je_lab4.data.DatingTable;
import com.example.je_lab4.model.DatesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface DeleteDateRepository extends JpaRepository<DatingTable, Integer> {
    @Modifying
    @Query(value = """ 
        DELETE FROM `dating_table` WHERE  `ID`=?1
""", nativeQuery = true)
    void deleteDate(int dateId);
}
