package com.studybuddy.notes.entity;

import com.studybuddy.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Title is required")
    @Size(min = 3, message = "Title must be at least 3 characters")
    private String title;

    @Column(length = 5000)
    @NotBlank(message = "Content is required")
    @Size(min = 5, message = "Content must be at least 5 characters")
    private String content;

    // ✅ SUBJECT FIELD
    @Column(nullable = false)
    @NotBlank(message = "Subject is required")
    private String subject;

    // 🔐 LINK NOTE TO USER (CORRECT PLACE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // ✅ Default constructor
    public Note() {
    }

    // ✅ Getters & Setters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

