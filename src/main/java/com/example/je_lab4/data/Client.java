package com.example.je_lab4.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "surname", nullable = false)
    private String surname;

    @Lob
    @Column(name = "aboutyourself", nullable = false)
    private String aboutYourself;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "photo")
    private String photo;

}