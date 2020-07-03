package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book = new Book(1, "Война и мир", 15, "Лев Николаевич Толстой");

    @Test
    void shouldMatchesByName() {

        String text = "Война и мир";

        assertTrue(book.matches(text));
    }

    @Test
    void shouldMatchesByAuthor() {

        String text = "Лев Николаевич Толстой";

        assertTrue(book.matches(text));
    }
}