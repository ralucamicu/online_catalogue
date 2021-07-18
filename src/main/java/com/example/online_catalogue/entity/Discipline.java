package com.example.online_catalogue.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Discipline {

    private int iD;
    private String numeDisc;
    private String an;
    private int credite;
}
