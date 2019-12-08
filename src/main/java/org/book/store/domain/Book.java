package org.book.store.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @SequenceGenerator(sequenceName = "book_id_seq", name = "book_seq_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_generator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "book")
    private BookDetails details;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", year=" + year +
                ", publisher=" + publisher +
                ", details=" + details +
                '}';
    }
}
