-- Seed base categories; ON CONFLICT relies on unique name constraint
INSERT INTO category (name, description)
VALUES
    ('History', 'World and U.S. history'),
    ('Science', 'Physics, Chemistry, and Biology basics'),
    ('Math', 'Arithmetic for all'),
    ('Geography', 'Countries all over the world')
ON CONFLICT (name) DO NOTHING;

-- Example flashcards for History
INSERT INTO flashcard (question, answer, difficulty, category_id)
VALUES
    ('Who was the first President of the United States?', 'George Washington', 'EASY', 1),
    ('What year did WWII end?', '1945', 'MEDIUM', 1),
    ('When was The People''s Republic of China founded?', '1949', 'HARD', 1)
ON CONFLICT (question, category_id) DO NOTHING;

-- Example flashcards for Science
INSERT INTO flashcard (question, answer, difficulty, category_id)
VALUES
    ('What is the chemical symbol for water?', 'H2O', 'EASY', 2),
    ('What planet is known as the Red Planet?', 'Mars', 'EASY', 2),
    ('What is the speed of light in vacuum (m/s)?', '299792458', 'HARD', 2)
ON CONFLICT (question, category_id) DO NOTHING;

-- Example flashcards for Math
INSERT INTO flashcard (question, answer, difficulty, category_id)
VALUES
    ('What is 2 + 2?', '4', 'EASY', 3),
    ('What is the square root of 144?', '12', 'MEDIUM', 3),
    ('What is the derivative of x^2?', '2x', 'HARD', 3)
ON CONFLICT (question, category_id) DO NOTHING;

-- Example flashcards for Geography
INSERT INTO flashcard (question, answer, difficulty, category_id)
VALUES
    ('What is the capital of France?', 'Paris', 'EASY', 4),
    ('Which river runs through Cairo?', 'Nile', 'MEDIUM', 4),
    ('What is the largest desert in the world?', 'Sahara', 'HARD', 4)
ON CONFLICT (question, category_id) DO NOTHING;
