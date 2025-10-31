package org.example.flashcardquizspring.repository;

import org.example.flashcardquizspring.entities.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {

    List<Flashcard> findByCategoryId(long categoryId);
}