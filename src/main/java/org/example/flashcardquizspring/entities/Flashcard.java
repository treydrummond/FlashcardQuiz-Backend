package org.example.flashcardquizspring.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flashcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String answer;
    private String difficulty; //EASY, MEDIUM, or HARD

    //Each category has multiple flashcards
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}