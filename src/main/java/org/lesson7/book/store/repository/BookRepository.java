package org.lesson7.book.store.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lesson7.book.store.domain.Book;
import java.util.List;

@RequiredArgsConstructor
public class BookRepository {
    private final SessionFactory factory;

    public Book createBook(String name, String isbn, Integer year) {
        Session session = factory.openSession();
        session.beginTransaction();

        Book book = new Book(isbn, name, year);
        session.persist(book);

        session.getTransaction().commit();
        session.close();

        return book;
    }

    public Book updateBook(Integer id, String name, String isbn, Integer year) {
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

    public Book deleteBook(Integer id) {
        Session session = factory.openSession();
        session.beginTransaction();

        Book book = session.get(Book.class, id);
        session.delete(book);

        session.getTransaction().commit();
        session.close();

        return book;
    }

    public Book getBookById(Integer id) {
        Session session = factory.openSession();

        Book book = session.get(Book.class, id);

        session.close();

        System.out.printf(" id = %d, name = %s, isbn = %s, year = %d",
                book.getId(), book.getName(), book.getIsbn(), book.getYear());

        return book;
    }

    public List<Book> getAllBook() {
        List<Book> bookList;
        Session session = factory.openSession();

        bookList = session.createQuery("from Book", Book.class).getResultList();

        session.close();

        return bookList;
    }
}
