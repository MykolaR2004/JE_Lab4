package com.example.je_lab4.repositories;

import com.example.je_lab4.data.Client;
import com.example.je_lab4.model.ClientsReqsHobbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SortedClientsRepository extends JpaRepository<Client, Integer>{
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
    FROM\s
        client C, hobbies H, hobbylist HL, requirements R, requirements_list RL
    WHERE\s
        HL.User_ID = C.id\s
        AND HL.Hobby_ID = H.ID\s
        AND RL.User_ID = C.id\s
        AND R.ID = RL.requirement_id
    ORDER BY
    CASE ?1
        WHEN 'id' THEN CAST(C.id AS SIGNED)
        WHEN 'name' THEN C.name
        WHEN 'surname' THEN C.surname
        WHEN 'aboutYourself' THEN C.aboutYourself
        WHEN 'age' THEN TIMESTAMPDIFF(YEAR, C.birthdate, CURDATE())
        WHEN 'sex' THEN C.sex
        WHEN 'birthdate' THEN C.birthdate
        WHEN 'hobby' THEN H.Hobby

    END
""", nativeQuery = true)

    List<ClientsReqsHobbs> getClientsWithReqsHobbsSortedByName(String sortBy);
}



