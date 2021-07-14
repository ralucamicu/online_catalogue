package com.example.online_catalogue.controller;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

    private String email;
    private String nume;
    private String prenume;
    private String parola;
    private String cnfParola;
}
