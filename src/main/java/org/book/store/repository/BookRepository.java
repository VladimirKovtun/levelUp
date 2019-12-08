package org.book.store.repository;

import lombok.RequiredArgsConstructor;
import org.book.store.domain.BookDetails;
import org.book.store.domain.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.book.store.domain.Book;
import java.util.List;

@RequiredArgsConstructor
public class BookRepository {
    private final SessionFactory factory;

    public Book create(String name, String isbn, Integer year, Publisher publisher, BookDetails details) {
        Session session = factory.openSession();
        session.beginTransaction();

        Book book = new Book();
        book.setName(name);
        book.setIsbn(isbn);
        book.setYear(year);
        book.setPublisher(publisher);

        if (details != null) {
            details.setBook(book);
            book.setDetails(details);
        }
        session.persist(book);

        session.getTransaction().commit();
        session.close();

        return book;
    }

    public Book update(Integer id, String name, String isbn, Integer year) {
        Session session = factory.openSession();
        session.beginTransaction();

        Book book = session.get(Book.class, id);
        book.setName(name);
        book.setIsbn(isbn);
        book.setYear(year);

        session.getTransaction().commit();
        session.close();

        return book;
    }

    public Book deleteById(Integer id) {
        Session session = factory.openSession();
        session.beginTransaction();

        Book book = session.get(Book.class, id);
        session.delete(book);

        session.getTransaction().commit();
        session.close();

        return book;
    }

    public Book findById(Integer id) {
        Session session = factory.openSession();

        Book book = session.get(Book.class, id);

        session.close();

        return book;
    }

    public List<Book> findAll() {
        List<Book> bookList;
        Session session = factory.openSession();

        bookList = session.createQuery("from Book", Book.class).getResultList();

        session.close();

        return bookList;
    }

    public List<Book> findByName(String name) {
        Session session = factory.openSession();

        List<Book> nameList = session.createQuery("FROM Book WHERE name = :name", Book.class)
                                  .setParameter("name", name).getResultList();

        session.close();

        return nameList;
    }
}
