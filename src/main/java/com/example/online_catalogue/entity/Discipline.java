package com.example.online_catalogue.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cursuri")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "cod_disciplina")
    private int cod_disciplina;

    @Column(name = "nume_disciplina")
    private String nume_disciplina;

    @Column(name = "an")
    private String an;

    @Column(name = "credite")
    private int credite;
}
