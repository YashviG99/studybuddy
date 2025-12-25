package com.studybuddy.notes.controller;

import com.studybuddy.user.User;
import com.studybuddy.user.UserRepository;
import com.studybuddy.notes.entity.Note;
import com.studybuddy.notes.repository.NoteRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;




import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    public NoteController(UserRepository userRepository,
                          NoteRepository noteRepository) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody Note note) {

        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        note.setUser(user);

        Note saved = noteRepository.save(note);

        return ResponseEntity.ok(saved);
    }


    @GetMapping
    public List<Note> getNotes() {

        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return noteRepository.findByUser(user);
    }



}
