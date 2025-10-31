package org.example.flashcardquizspring.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    // Every flashcard needs a category
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Flashcard> flashcards;
}
