package com.example.online_catalogue.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    List<User> utilizatori = getUtilizatori();
    List<Note> note = dispGrades();

    private List<User> getUtilizatori (){
        List<User> utilizatori = new ArrayList<>();
        utilizatori.add(User.builder().nume("maroiu").prenume("alex").email("alex@mail.com").parola("pass").build());
        return utilizatori;
    }

    @GetMapping(value = "/login")
    public ModelAndView login(Model model) {
        ModelAndView mav = new ModelAndView();

        User utilizator = new User();
        model.addAttribute("user",utilizator);

        mav.setViewName("login");
        return mav;
    }

    @PostMapping(value = "/submitLogin")
    public ModelAndView submitLogin(@ModelAttribute User utilizator){
        ModelAndView mav = new ModelAndView();

        for(var user : utilizatori){
           if(user.getParola().equals(utilizator.getParola()) && user.getEmail().equals(utilizator.getEmail())){
               mav.setViewName("redirect:/index");
           }
           else{
               mav.setViewName("redirect:/login");
           }
        }

        return mav;
    }

    @GetMapping(value = "/register")
    public ModelAndView register(Model model){
        ModelAndView mav = new ModelAndView();

        User utilizator = User.builder().build();
        model.addAttribute("utilizator",utilizator);

        mav.setViewName("register");
        return mav;
    }

    @PostMapping(value = "/submitRegister")
    public ModelAndView submitRegister(@ModelAttribute User utilizator){
        ModelAndView mav = new ModelAndView();

        if(utilizator.getParola().equals(utilizator.getCnfParola())) {
            utilizatori.add(utilizator);
            mav.setViewName("redirect:/login");
        }
        else{
            mav.setViewName("redirect:/register");
        }
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

        model.addAttribute("note", note);

        mav.setViewName("displayNote");
        return mav;
    }

    @GetMapping(value = "/addNote")
    public ModelAndView addNote(Model model){
        ModelAndView mav = new ModelAndView();

        Note nota = new Note();
        model.addAttribute("nota",nota);

        mav.setViewName("addNote");
        return mav;
    }

    @PostMapping(value = "/submitNota")
    public ModelAndView submitNota(@ModelAttribute Note nota){
        ModelAndView mav = new ModelAndView();

        nota.setId(note.size()+1);
        note.add(nota);

        mav.setViewName("redirect:/grades");
        return mav;
    }

    @GetMapping(value = "/index")
    public ModelAndView home(Model model){
        ModelAndView mav = new ModelAndView();



        mav.setViewName("index");
        return mav;

    }

    @GetMapping(value = "/exams")
    public ModelAndView exams(Model model){
        ModelAndView mav = new ModelAndView();



        mav.setViewName("exams");
        return mav;

    }

    @GetMapping(value = "/courses")
    public ModelAndView courses(Model model){
        ModelAndView mav = new ModelAndView();

        model.addAttribute("greetings", "My Sujects : ");

        List<String> nameDiscList = List.of("Electronica Digitala", "PCLP", "Proiectarea Algoritmilor", "Informatica Aplicata");
        model.addAttribute("nameDiscList", nameDiscList);

        List<Discipline> discipline = dispSubjects();
        model.addAttribute("discipline", discipline);


        mav.setViewName("courses");

        return mav;

    }

    private List<Note> dispGrades() {
        List<Note> note = new ArrayList<>();
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

        //List.of(dispGrades1, dispGrades2, dispGrades3, dispGrades4, dispGrades5, dispGrades6, dispGrades7,dispGrades8
        //                ,dispGrades9,dispGrades10)
        note.add(dispGrades1);
        note.add(dispGrades2);
        note.add(dispGrades3);
        note.add(dispGrades4);
        note.add(dispGrades5);
        note.add(dispGrades6);
        note.add(dispGrades7);
        note.add(dispGrades8);
        note.add(dispGrades9);
        note.add(dispGrades10);
        return note;
    }

    private List<Discipline> dispSubjects() {
        Discipline dispSubjects1 = Discipline.builder()
                .iD(001)
                .numeDisc("Electronica Digitala")
                .an("IV")
                .credite(5)
                .build();

        Discipline dispSubjects2 = Discipline.builder()
                .iD(2)
                .numeDisc("Electronica Digitala")
                .an("II")
                .credite(4)
                .build();
        Discipline dispSubjects3 = Discipline.builder()
                .iD(3)
                .numeDisc("Electronica Digitala")
                .an("II")
                .credite(5)
                .build();
        Discipline dispSubjects4 = Discipline.builder()
                .iD(4)
                .numeDisc("Electronica Digitala")
                .an("I")
                .credite(6)
                .build();
        Discipline dispSubjects5 = Discipline.builder()
                .iD(5)
                .numeDisc("Electronica Digitala")
                .an("V")
                .credite(6)
                .build();
        Discipline dispSubjects6 = Discipline.builder()
                .iD(6)
                .numeDisc("Electronica Digitala")
                .an("IV")
                .credite(1)
                .build();
        Discipline dispSubjects7 = Discipline.builder()
                .iD(7)
                .numeDisc("Electronica Digitala")
                .an("III")
                .credite(4)
                .build();
        Discipline dispSubjects8 = Discipline.builder()
                .iD(8)
                .numeDisc("Electronica Digitala")
                .an("I")
                .credite(5)
                .build();
        Discipline dispSubjects9 = Discipline.builder()
                .iD(9)
                .numeDisc("Electronica Digitala")
                .an("II")
                .credite(7)
                .build();
        Discipline dispSubjects10 = Discipline.builder()
                .iD(10)
                .numeDisc("Electronica Digitala")
                .an("VI")
                .credite(3)
                .build();
        return List.of(dispSubjects1, dispSubjects2, dispSubjects3, dispSubjects4, dispSubjects5, dispSubjects6, dispSubjects7,
                dispSubjects8, dispSubjects9, dispSubjects10);
    }

}
