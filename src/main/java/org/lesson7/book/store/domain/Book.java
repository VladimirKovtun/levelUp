package org.lesson7.book.store.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "year")
    private Integer year;

    public Book(String isbn, String name, Integer year) {
        this.isbn = isbn;
        this.name = name;
        this.year = year;
    }
}
