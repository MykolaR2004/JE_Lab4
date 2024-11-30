package com.example.je_lab4.repositories;

import com.example.je_lab4.data.Client;
import com.example.je_lab4.model.ClientIdNameSurname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientIdNameSurnameRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
SELECT
	C.id,
   CONCAT(C.name, ' ', C.surname) AS clientNameSurname
FROM client C
WHERE C.id = ?1
""", nativeQuery = true)
    ClientIdNameSurname getClientNameSurname(int clientid);

}
