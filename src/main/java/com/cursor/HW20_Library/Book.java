package com.cursor.HW20_Library;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private boolean available;
    private boolean done;

    public Book(String title) {
        this.title = title;
        this.available = false;
        this.done = false;
    }
}
