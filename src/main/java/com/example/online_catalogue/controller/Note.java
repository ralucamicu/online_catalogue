package com.example.online_catalogue.controller;

import lombok.*;

@Getter
@Setter
@Builder
public class Note {

    private int id;
    private String discName;
    private int nota;
    private String promovat;
    private String departmentName;

}