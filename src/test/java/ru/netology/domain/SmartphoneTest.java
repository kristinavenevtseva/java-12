package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    Smartphone smartphone = new Smartphone(1, "Samsung Galaxy A51", 12, "Samsung");

    @Test
    void shouldMatchesByName() {

        String text = "Samsung Galaxy A51";

        assertTrue(smartphone.matches(text));
    }

    @Test
    void shouldMatchesByManufacturer() {

        String text = "Samsung";

        assertTrue(smartphone.matches(text));
    }
}