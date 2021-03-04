package com.cursor.HW20_Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return  bookRepository.findById(id).orElse(null);
    }
    @GetMapping("/books/finished/{id}")
    public Book getAllReservations(@PathVariable("id") Long id){
        Book finishedBook = bookRepository.findById(id).get();
        finishedBook.setAvailable(true);
        finishedBook.setDone(false);
        bookRepository.save(finishedBook);
        return finishedBook;
    }
    @GetMapping("/books/borrowing/{id}")
    public String doneBorrowing(@PathVariable("id") Long id) {
        Book borrowedBook = bookRepository.findById(id).get();
        if (borrowedBook != null) {
            borrowedBook.setAvailable(false);
            borrowedBook.setDone(true);
            bookRepository.save(borrowedBook);
        }
        return borrowedBook.getTitle();
    }
}
