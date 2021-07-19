package com.example.online_catalogue.repository;

import com.example.online_catalogue.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
