package com.example.online_catalogue.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping(value = "/login")
    public ModelAndView login(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @GetMapping(value = "/register")
    public ModelAndView register(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }

    @GetMapping(value = "/recuperare")
    public ModelAndView password(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("password");
        return mav;
    }



    @GetMapping(value = "/grades")
    public ModelAndView viewGrades(Model model) {
        ModelAndView mav = new ModelAndView();

        model.addAttribute("greetings", "My Grades : ");

        List<String> discNameList = List.of("Electronica Digitala", "PCLP", "Radiologie", "Informatica Aplicata");
        model.addAttribute("discNameList", discNameList);

        List<Note> note = dispGrades();
        model.addAttribute("note", note);

        mav.setViewName("displayNote");
        return mav;
    }

    @GetMapping(value = "/home")
    public ModelAndView home(Model model){
        ModelAndView mav = new ModelAndView();



        mav.setViewName("home");
        return mav;

    }

    private List<Note> dispGrades() {
        Note dispGrades1 = Note.builder()
                .id(001)
                .discName("Electronica Digitala")
                .nota(6)
                .promovat("Promovat")
                .departmentName("Tehnologia Informatiei")
                .build();

        Note dispGrades2 = Note.builder()
                .id(002)
                .discName("Baze de date")
                .nota(9)
                .promovat("Promovat")
                .departmentName("Tehnologia Informatiei")
                .build();

        Note dispGrades3 = Note.builder()
                .id(003)
                .discName("POO")
                .nota(10)
                .promovat("Promovat")
                .departmentName("Tehnologia Informatiei")
                .build();

        Note dispGrades4 = Note.builder()
                .id(004)
                .discName("Teoria sistemelor")
                .nota(8)
                .promovat("Promovat")
                .departmentName("Tehnologia Informatiei")
                .build();

        Note dispGrades5 = Note.builder()
                .id(005)
                .discName("Elemente de grafica pe calculator")
                .nota(10)
                .promovat("Promovat")
                .departmentName("Tehnologia Informatiei")
                .build();

        Note dispGrades6 = Note.builder()
                .id(006)
                .discName("Elemente de grafica pe calculator")
                .nota(10)
                .promovat("Promovat")
                .departmentName("Tehnologia Informatiei")
                .build();

        Note dispGrades7 = Note.builder()
                .id(007)
                .discName("Procesarea semnalelor")
                .nota(7)
                .promovat("Promovat")
                .departmentName("Tehnologia Informatiei")
                .build();

        Note dispGrades8 = Note.builder()
                .id(8)
                .discName("Limba engleza")
                .nota(5)
                .promovat("Promovat")
                .departmentName("Tehnologia Informatiei")
                .build();

        Note dispGrades9 = Note.builder()
                .id(9)
                .discName("Proiectarea algoritmilor")
                .nota(4)
                .promovat("Nepromovat")
                .departmentName("Tehnologia Informatiei")
                .build();

        Note dispGrades10 = Note.builder()
                .id(10)
                .discName("Structuri de date si algoritmi")
                .nota(10)
                .promovat("Promovat")
                .departmentName("Tehnologia Informatiei")
                .build();

        return List.of(dispGrades1, dispGrades2, dispGrades3, dispGrades4, dispGrades5, dispGrades6, dispGrades7,dispGrades8 ,dispGrades9,dispGrades10);
    }


}
