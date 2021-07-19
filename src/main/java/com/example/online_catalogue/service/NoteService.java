package com.example.online_catalogue.service;

import com.example.online_catalogue.entity.Note;
import com.example.online_catalogue.controller.Controller;
import com.example.online_catalogue.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<Note> getNote(){
        return noteRepository.findAll();
    }

    public void saveNoteToDatabase(Note nota) {
        noteRepository.save(nota);
    }
}
