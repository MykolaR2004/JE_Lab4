package com.example.je_lab4.repositories;

import com.example.je_lab4.data.Client;
import com.example.je_lab4.model.ClientsReqsHobbs;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = """ 
    SELECT
    C.id,
    C.name,
    C.surname,
    C.aboutYourself,
    TIMESTAMPDIFF(YEAR, C.birthdate, CURDATE()) AS age,
    C.sex,
    C.birthdate,
    H.Hobby,
    R.Requirement
FROM
    client C
    JOIN hobbylist HL ON HL.User_ID = C.id
    JOIN hobbies H ON HL.Hobby_ID = H.ID
    JOIN requirements_list RL ON RL.User_ID = C.id
    JOIN requirements R ON R.ID = RL.requirement_id
ORDER BY
    C.ID
""", nativeQuery = true)
    List<ClientsReqsHobbs> getClientsWithReqsHobbs();

}

