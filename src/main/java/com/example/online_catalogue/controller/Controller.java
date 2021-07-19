package com.example.online_catalogue.controller;

import com.example.online_catalogue.entity.Discipline;
import com.example.online_catalogue.entity.Note;
import com.example.online_catalogue.entity.User;
import com.example.online_catalogue.repository.NoteRepository;
import com.example.online_catalogue.service.DisciplineService;
import com.example.online_catalogue.service.NoteService;
import com.example.online_catalogue.service.UserService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    DisciplineService disciplineService;

    @Autowired
    NoteService noteService;



    //Login
    @GetMapping(value = "/login")
    public ModelAndView login(Model model) {
        ModelAndView mav = new ModelAndView();

        System.out.println(new User.Inregistrare().getCnfParola());

        User utilizator = new User();
        model.addAttribute("user",utilizator);

        mav.setViewName("login");
        return mav;
    }
    @PostMapping(value = "/submitLogin")
    public ModelAndView submitLogin(@ModelAttribute User utilizator){
        ModelAndView mav = new ModelAndView();

        var utilizatori = userService.getUsers();

        mav.setViewName("redirect:/login");

        for(var user : utilizatori){
           if(user.getParola().equals(utilizator.getParola()) && user.getEmail().equals(utilizator.getEmail())){
               mav.setViewName("redirect:/index");
           }
        }

        return mav;
    }
    //End Login



    //Register
    @GetMapping(value = "/register")
    public ModelAndView register(Model model){
        ModelAndView mav = new ModelAndView();

        User.Inregistrare utilizator = new User.Inregistrare();
        model.addAttribute("utilizator",utilizator);

        mav.setViewName("register");
        return mav;
    }
    @PostMapping(value = "/submitRegister")
    public ModelAndView submitRegister(@ModelAttribute User.Inregistrare utilizator){
        ModelAndView mav = new ModelAndView();

        if(utilizator.notNull()){
            //utilizatori.add(utilizator);
            userService.saveUser(utilizator.getUser());
            mav.setViewName("redirect:/login");
        }
        else{
            mav.setViewName("redirect:/register");
        }
        return mav;
    }
    //End register



    //Recuperare
    @GetMapping(value = "/recuperare")
    public ModelAndView password(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("password");
        return mav;
    }
    //End recuperare



    //Adaugare de note
    @GetMapping(value = "/grades")
    public ModelAndView viewGrades(Model model) {
        ModelAndView mav = new ModelAndView();

        List<Note> nota = noteService.getNote();
        model.addAttribute("nota", nota);

        mav.setViewName("grades");
        return mav;
    }
        @GetMapping(value = "/addNote")
    public ModelAndView addNote(Model model){
        ModelAndView mav = new ModelAndView();

        Note note = new Note();
        model.addAttribute("note",note);

        mav.setViewName("addNote");
        return mav;
    }
    @PostMapping(value = "/submitNota")
    public ModelAndView submitNota(@ModelAttribute Note nota){
        ModelAndView mav = new ModelAndView();

        noteService.saveNoteToDatabase(nota);

        mav.setViewName("redirect:/grades");
        return mav;
    }
    //End Adaugare de note



    //Adaugare de discipline
    @GetMapping(value = "/courses")
    public ModelAndView courses(Model model){
        ModelAndView mav = new ModelAndView();

        List<Discipline> disciplina = disciplineService.getDiscipline();
        model.addAttribute("disciplina", disciplina);


        mav.setViewName("courses");

        return mav;
    }
    @GetMapping(value = "/addCourses")
    public ModelAndView addCourses(Model model){
        ModelAndView mav = new ModelAndView();

        Discipline discipline = new Discipline();
        model.addAttribute("discipline",discipline);

        mav.setViewName("addCourses");
        return mav;
    }
    @PostMapping(value = "/submitCourses")
    public ModelAndView submitCourses(@ModelAttribute Discipline discipline){
        ModelAndView mav = new ModelAndView();

        disciplineService.saveDisciplineToDatabase(discipline);

        mav.setViewName("redirect:/courses");
        return mav;
    }
    //End Adaugare de discipline



    //Home page
    @GetMapping(value = "/index")
    public ModelAndView home(Model model){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("index");
        return mav;
    }
    //End Home page



    //Adaugare de examene
    @GetMapping(value = "/exams")
    public ModelAndView exams(Model model){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("exams");
        return mav;
    }
    //End Adaugare de examene


}
