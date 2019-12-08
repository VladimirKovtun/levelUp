package org.book.store;

import org.hibernate.SessionFactory;
import org.book.store.domain.Book;
import org.book.store.domain.Publisher;
import org.book.store.repository.BookRepository;
import org.book.store.repository.PublisherRepository;

import java.util.List;

public class App {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getFactory();
        BookRepository bookRepository = new BookRepository(factory);
        PublisherRepository publisherRepository = new PublisherRepository(factory);

        Publisher publisher = publisherRepository.create("Москва 2.0");
        Publisher publisher1 = publisherRepository.create("Piter");
        Publisher publisher2 = publisherRepository.create("O'reilly");
        //publisherRepository.update(publisher.getId(), "Moscow 1.0");
        List<Publisher> allPublisher = publisherRepository.findAll();
        for (Publisher p : allPublisher) {
            System.out.println(p.getName());
        }

        System.out.println(" ");

        /*Book book = bookRepository.create("BookName", "24-534-43-23424", 2016);
        Book book1 = bookRepository.create("BookName1", "2344-34-543-234", 2007);
        Book book2 = bookRepository.create("BookName2", "243-53774-483-274", 2015);*/
        List<Book> allBook = bookRepository.findAll();
        for (Book b : allBook) {
            System.out.println(b.getName());
        }
    }
}
