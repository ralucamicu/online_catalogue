package com.example.online_catalogue.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Note {

    private int id;
    private String discName;
    private int nota;
    private String situatie;
    private String departmentName;

}