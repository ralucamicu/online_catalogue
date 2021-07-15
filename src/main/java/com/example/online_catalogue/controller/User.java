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

    public boolean notNull(){
        if(email.equals("")){
            return false;
        }
        if(nume.equals("")){
            return false;
        }
        if(prenume.equals("")){
            return false;
        }
        if(parola.equals("")){
            return false;
        }
        if(cnfParola.equals("")){
            return false;
        }
        if(!(parola.equals(cnfParola))){
            return false;
        }

        return true;
    }
}
