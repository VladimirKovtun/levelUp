package org.lesson7.book.store;

import org.hibernate.SessionFactory;
import org.lesson7.book.store.domain.Book;
import org.lesson7.book.store.domain.Publisher;
import org.lesson7.book.store.repository.BookRepository;
import org.lesson7.book.store.repository.PublisherRepository;

import java.util.List;

public class App {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtils.getFactory();
        BookRepository bookRepository = new BookRepository(factory);
        PublisherRepository publisherRepository = new PublisherRepository(factory);

        Publisher publisher = publisherRepository.createPublisher("Москва 2.0");
        Publisher publisher1 = publisherRepository.createPublisher("Piter");
        Publisher publisher2 = publisherRepository.createPublisher("O'reilly");
        //publisherRepository.updatePublisher(publisher.getId(), "Moscow 1.0");
        List<Publisher> allPublisher = publisherRepository.getAllPublisher();
        for (Publisher p : allPublisher) {
            System.out.println(p.getName());
        }

        System.out.println(" ");

        Book book = bookRepository.createBook("BookName", "24-534-43-23424", 2016);
        Book book1 = bookRepository.createBook("BookName1", "2344-34-543-234", 2007);
        Book book2 = bookRepository.createBook("BookName2", "243-53774-483-274", 2015);
        List<Book> allBook = bookRepository.getAllBook();
        for (Book b : allBook) {
            System.out.println(b.getName());
        }
    }
}
