package org.example.flashcardquizspring.controller;

import org.example.flashcardquizspring.dto.CategoryDto;
import org.example.flashcardquizspring.dto.FlashcardDto;
import org.example.flashcardquizspring.entities.Category;
import org.example.flashcardquizspring.entities.Flashcard;
import org.example.flashcardquizspring.repository.CategoryRepository;
import org.example.flashcardquizspring.repository.FlashcardRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final FlashcardRepository flashcardRepository;

    public CategoryController(CategoryRepository categoryRepository,
                              FlashcardRepository flashcardRepository) {
        this.categoryRepository = categoryRepository;
        this.flashcardRepository = flashcardRepository;
    }

   
     //Get categories for CategoryList
    @GetMapping
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        
        for (Category category : categories) {
            CategoryDto dto = new CategoryDto(
                    category.getId(),
                    category.getName(),
                    category.getDescription(),
                    category.getFlashcards() != null ? category.getFlashcards().size() : 0
            );
            categoryDtos.add(dto);
        }
        
        return categoryDtos;
    }

    //Get category by id
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        if (categoryRepository.existsById(id)) {
            return categoryRepository.findById(id).get();
        }
        else{
            return null;
        }
    }

    //Get flashcards for QuizPage
    @GetMapping("/{id}/flashcards")
    public List<FlashcardDto> getFlashcardsByCategory(@PathVariable Long id) {
        List<Flashcard> flashcards = flashcardRepository.findByCategoryId(id);
        List<FlashcardDto> flashcardDtos = new ArrayList<>();
        
        for (Flashcard flashcard : flashcards) {
            FlashcardDto dto = new FlashcardDto(
                    flashcard.getId(),
                    flashcard.getQuestion(),
                    flashcard.getAnswer(),
                    flashcard.getDifficulty(),
                    flashcard.getCategory().getId(),
                    flashcard.getCategory().getName()
            );
            flashcardDtos.add(dto);
        }
        
        return flashcardDtos;
    }
}