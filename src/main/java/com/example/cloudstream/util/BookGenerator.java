package com.example.cloudstream.util;

import com.example.cloudstream.model.Book;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BookGenerator {
    private final Random r = new Random();

    public Book generateNewBook() {
        return new Book(
                r.nextInt(100),
                "name-" + r.nextInt(100),
                "description-" + r.nextInt(100),
                "unchecked",
                r.nextInt(100)
        );
    }
}
