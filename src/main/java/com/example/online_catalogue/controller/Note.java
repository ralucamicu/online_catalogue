package com.example.online_catalogue.controller;

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
    private String promovat;
    private String departmentName;

}