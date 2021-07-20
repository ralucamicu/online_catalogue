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
@Table(name = "examene")
public class Examene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cod_disciplina")
    private int cod_disciplina;

    @Column(name = "nume_disciplina")
    private int nume_disciplina;

    @Column(name = "data")
    private String data;

    @Column(name = "ora")
    private String ora;

}