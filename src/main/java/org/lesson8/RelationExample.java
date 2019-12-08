package org.lesson8;

import org.book.store.domain.Book;
import org.book.store.domain.BookDetails;
import org.book.store.domain.Publisher;
import org.book.store.repository.BookRepository;
import org.book.store.repository.PublisherRepository;
import org.hibernate.SessionFactory;
import org.book.store.HibernateUtils;

import java.util.List;

public class RelationExample {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getFactory();
        PublisherRepository publisherRepository = new PublisherRepository(factory);
        BookRepository bookRepository = new BookRepository(factory);

        /*Publisher publisher = new Publisher("Piter");
        session.save(publisher);

        Book book = new Book();
        book.setIsbn("23434-6546");
        book.setName("Book#2");
        book.setYear(2012);

        book.setPublisher(publisher);
        session.save(book);
*/
        /*Book book = new Book();
        book.setName("Book#6");
        book.setIsbn("222-62-1413");
        book.setYear(2015);
        book.setPublisher(publisher);*/
        Publisher publisher = publisherRepository.findById(2);

        BookDetails details = new BookDetails();
        details.setPagesCount(545);
        details.setGenre("Genre#7");
        bookRepository.create("Book#8", "2242-622-143", 2014, publisher, details);

        /*details.setBook(book);
        book.setDetails(details);
        session.persist(book);*/

        List<Book> byName = bookRepository.findByName("Book#5");
        byName.forEach(System.out::println);
    }
}
