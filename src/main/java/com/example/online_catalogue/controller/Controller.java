package com.example.online_catalogue.controller;

import com.example.online_catalogue.model.AlertDTO;
import com.example.online_catalogue.model.AlertType;
import com.example.online_catalogue.entity.Discipline;
import com.example.online_catalogue.entity.Examene;
import com.example.online_catalogue.entity.Note;
import com.example.online_catalogue.entity.User;
import com.example.online_catalogue.service.DisciplineService;
import com.example.online_catalogue.service.ExameneService;
import com.example.online_catalogue.service.NoteService;
import com.example.online_catalogue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    UserService userService;

    @Autowired
    DisciplineService disciplineService;

    @Autowired
    NoteService noteService;

    @Autowired
    ExameneService exameneService;

    User student;

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
               //model.addAttribute("student", user);
               student = user;
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
    public ModelAndView password(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("password");
        return mav;
    }
    //End recuperare



    //Adaugare de note
    @GetMapping(value = "/grades")
    public ModelAndView viewGrades(Model model) {
        ModelAndView mav = new ModelAndView();

        if(student == null){
            mav.setViewName("redirect:/login");
            return mav;
        }

        List<Note> nota = userService.getUsers().get(student.getId()-1).getNote();
        model.addAttribute("nota", nota);

        mav.setViewName("grades");
        return mav;
    }

    @GetMapping(value = "/addNote")
    public ModelAndView addNote(Model model){
        ModelAndView mav = new ModelAndView();

        Note note = new Note();
        model.addAttribute("note",note);

        List<User> studenti = userService.getUsers();
        model.addAttribute("studentiNote",studenti);

        model.addAttribute("discipline",disciplineService.getDiscipline());

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
    @PostMapping(value = "/editGrades")
    public ModelAndView editGrades(@RequestParam("id_nota") Integer id, Model model){
        ModelAndView mav = new ModelAndView();

        Note note = noteService.getNotaByID(id);
        model.addAttribute("note",note);

        model.addAttribute("studentiNote", student);
        model.addAttribute("discipline",note.getDisciplina());

        mav.setViewName("addNote");
        return mav;
    }
//    @PostMapping(value = "/deleteGrades")
    //@ResponseBody
//    public ModelAndView deleteGrades(@RequestParam("id_nota") Integer id, Model model,final RedirectAttributes redirectAttributes){
//        ModelAndView mav = new ModelAndView();
//        AlertDTO alert;
//
//        int deletedNotaID = noteService.deleteNotaByID(id);
//
//        if (deletedNotaID != 0) {
//            alert = new AlertDTO("Operation successful.", "The department was deleted.", AlertType.SUCCES);
//        } else {
//            alert = new AlertDTO("Error during department deletion.", "An error occured while trying to delete the department.", AlertType.ERROR);
//        }
//        model.addAttribute("deletedNotaID",deletedNotaID);
//
//        model.addAttribute("studentiNote", student);
//
//        mav.setViewName("grades");
//        redirectAttributes.addFlashAttribute("alert", alert);
//        return mav;
//    }
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

    @PostMapping(value = "/editCourses")
    public ModelAndView editCourses(@RequestParam("cod_disciplina")Integer id, Model model){
        ModelAndView mav = new ModelAndView();
        Discipline discipline = disciplineService.getDisciplineById(id);

        model.addAttribute("discipline",discipline);
        mav.setViewName("addCourses");
        return mav;
    }
    //End Adaugare de discipline



    //Home page
    @GetMapping(value = "/index")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("index");
        return mav;
    }
    //End Home page



    //Adaugare de examene
    @GetMapping(value = "/exams")
    public ModelAndView exams(Model model){
        ModelAndView mav = new ModelAndView();

        if(student == null){
            mav.setViewName("redirect:/login");
            return mav;
        }

        List<Examene> examen = userService.getUsers().get(student.getId()-1).getExamene();
        model.addAttribute("examen", examen);

        mav.setViewName("exams");
        return mav;
    }
    @GetMapping(value = "/addExams")
    public ModelAndView addExams(Model model){
        ModelAndView mav = new ModelAndView();

        Examene examene = new Examene();
        model.addAttribute("examene",examene);
        model.addAttribute("discipline",disciplineService.getDiscipline());
        model.addAttribute("studentiExam",userService.getUsers());

        mav.setViewName("addExams");
        return mav;
    }
    @PostMapping(value = "/submitExams")
    public ModelAndView submitExams(@ModelAttribute Examene examene){
        ModelAndView mav = new ModelAndView();

        exameneService.saveExameneToDatabase(examene);

        mav.setViewName("redirect:/exams");
        return mav;
    }
    @PostMapping(value = "/editExams")
    public ModelAndView editExams(@RequestParam("id_examen")Integer id, Model model){
        ModelAndView mav = new ModelAndView();

        Examene examene = exameneService.getExameneById(id);
        model.addAttribute("examene",examene);
        model.addAttribute("discipline",examene.getDisciplina());
        model.addAttribute("studentiExam",examene.getStudent());

        mav.setViewName("addExams");
        return mav;
    }
    //End Adaugare de examene


}
