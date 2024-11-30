package com.example.je_lab4.repositories;

import com.example.je_lab4.data.Client;
import com.example.je_lab4.model.ClientById;
import com.example.je_lab4.model.ClientsReqsHobbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientByIdRepository  extends JpaRepository<Client, Integer> {
    @Query(value = """ 
    SELECT
    C.id,
    C.name,
    C.surname,
    C.aboutYourself,
    TIMESTAMPDIFF(YEAR, C.birthdate, CURDATE()) AS age,
    C.sex,
    C.birthdate,
    C.photo,
        H.Hobby,
        R.Requirement,
        CH.Trait
    FROM
        client C, hobbies H, hobbylist HL, requirements R, requirements_list RL, characters CH, characters_list CL
    WHERE
    	C.id = ?1
      AND HL.User_ID = C.id
      AND HL.Hobby_ID = H.ID
      AND RL.User_ID = C.id
      AND R.ID = RL.requirement_id
      AND CL.User_ID = C.id
      AND CL.Character_ID = CH.ID
""", nativeQuery = true)
    ClientById getClientById(int clientid);

}
