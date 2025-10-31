package org.example.flashcardquizspring.controller;

import org.example.flashcardquizspring.entities.Category;
import org.example.flashcardquizspring.entities.Flashcard;
import org.example.flashcardquizspring.repository.CategoryRepository;
import org.example.flashcardquizspring.repository.FlashcardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Single Flashcard Operations for future 
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/flashcards")
public class FlashcardController {

    private final FlashcardRepository flashcardRepository;
    private final CategoryRepository categoryRepository;

    
    public FlashcardController(FlashcardRepository flashcardRepository,
                               CategoryRepository categoryRepository) {
        this.flashcardRepository = flashcardRepository;
        this.categoryRepository = categoryRepository;
    }


    //View all flashcards
    @GetMapping("/allFlashcards")
    public List<Flashcard> getAll() {
        return flashcardRepository.findAll();
    }

    //Get a single flashcard by ID
    @GetMapping("/{id}")
    public ResponseEntity<Flashcard> getOne(@PathVariable Long id) {
        if (flashcardRepository.existsById(id)) {
            Flashcard flashcard = flashcardRepository.findById(id).get();
            return ResponseEntity.ok(flashcard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Create new flashcard
    @PostMapping
    public ResponseEntity<Flashcard> create(@RequestBody Flashcard flashcard) {
        if (flashcard.getCategory() != null && flashcard.getCategory().getId() != null) {
            if (categoryRepository.existsById(flashcard.getCategory().getId())) {
                Category category = categoryRepository.findById(flashcard.getCategory().getId()).get();
                flashcard.setCategory(category);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(flashcardRepository.save(flashcard));
    }

    //Delete single flashcard by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!flashcardRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        flashcardRepository.deleteById(id);
        return ResponseEntity.ok("Flashcard deleted successfully.");
    }
}