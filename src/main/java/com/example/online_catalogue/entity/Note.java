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
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name = "cod_disciplina")
    private int cod_disciplina;

    @Column(name = "nume_disciplina")
    private String nume_disciplina;

    @Column(name = "nota")
    private int nota;

    @Column(name = "situatie")
    private String situatie;

    @Column(name = "departament")
    private String departament;

}