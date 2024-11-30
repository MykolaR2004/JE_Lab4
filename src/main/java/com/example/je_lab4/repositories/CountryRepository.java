package com.example.je_lab4.repositories;

import com.example.je_lab4.data.Country;
import com.example.je_lab4.model.CountryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query(value = """ 
            SELECT
               C.ID,
               C.Country_name
              FROM country C
""", nativeQuery = true)
    List<CountryList> getCountryList();

}
