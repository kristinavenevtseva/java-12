package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    private Book book = new Book();
    private Smartphone smartphone = new Smartphone();

    @Test
    void shouldSearchBookByName() {

        Book first = new Book(1, "Война и мир", 15, "Лев Николаевич Толстой");
        Book second = new Book(2, "Преступление и наказание", 9, "Фёдор Михайлович Достоевский");
        Book third = new Book(3, "Отцы и дети", 7, "Иван Сергеевич Тургенев");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        String name = "Война и мир";

        Product[] actual = manager.searchBy(name);
        Product[] expected = new Product[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {

        Book first = new Book(1, "Война и мир", 15, "Лев Николаевич Толстой");
        Book second = new Book(2, "Преступление и наказание", 9, "Фёдор Михайлович Достоевский");
        Book third = new Book(3, "Отцы и дети", 7, "Иван Сергеевич Тургенев");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        String author = "Иван Сергеевич Тургенев";

        Product[] actual = manager.searchBy(author);
        Product[] expected = new Product[]{third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {

        Smartphone first = new Smartphone(1, "Samsung Galaxy A51", 12, "Samsung");
        Smartphone second = new Smartphone(2, "iPhone 11", 23, "Apple");
        Smartphone third = new Smartphone(3, "Redmi 8", 8, " Xiaomi");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        String name = "Redmi 8";

        Product[] actual = manager.searchBy(name);
        Product[] expected = new Product[]{third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {

        Smartphone first = new Smartphone(1, "Samsung Galaxy A51", 12, "Samsung");
        Smartphone second = new Smartphone(2, "iPhone 11", 23, "Apple");
        Smartphone third = new Smartphone(3, "Redmi 8", 8, " Xiaomi");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        String manufacturer = "Apple";

        Product[] actual = manager.searchBy(manufacturer);
        Product[] expected = new Product[]{second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByEqualManufacturer() {

        Smartphone first = new Smartphone(1, "Samsung Galaxy A51", 12, "Apple");
        Smartphone second = new Smartphone(2, "iPhone 11", 23, "Apple");
        Smartphone third = new Smartphone(3, "Redmi 8", 8, "Apple");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        String manufacturer = "Apple";

        Product[] actual = manager.searchBy(manufacturer);
        Product[] expected = new Product[]{third, second, first};

        assertArrayEquals(expected, actual);
    }
}