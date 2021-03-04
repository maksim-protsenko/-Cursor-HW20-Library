package com.cursor.HW20_Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class DataCLR implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Stream.of("The $100 Startup",
                "The Art of the Start 2.0",
                "The E-Myth Revisited",
                "The Lean Startup",
                "The ONE Thing",
                "Virtual Freedom")
                .forEach(b -> bookRepository.save(new Book(b)));
    }
}
