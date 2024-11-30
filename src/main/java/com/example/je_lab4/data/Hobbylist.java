package com.example.je_lab4.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hobbylist")
public class Hobbylist {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID")
    private Client userID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Hobby_ID")
    private Hobby hobbyId;


}