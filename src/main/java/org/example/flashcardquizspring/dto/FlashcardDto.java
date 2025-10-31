package org.example.flashcardquizspring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlashcardDto {
    private Long id;
    private String question;
    private String answer;
    private String difficulty;
    private Long categoryId;
    private String categoryName;
}
