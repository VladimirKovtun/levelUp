package org.book.store.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "book_details")
public class BookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pages_count")
    private Integer pagesCount;
    private String genre;

    @OneToOne
    @MapsId
    //@JoinColumn(name = "book_id")
    private Book book;

    @Override
    public String toString() {
        return "BookDetails{" +
                "id=" + id +
                ", pagesCount=" + pagesCount +
                ", genre='" + genre + '\'' +
                '}';
    }
}
