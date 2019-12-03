package org.lesson7.book.store;

import org.hibernate.SessionFactory;
import org.lesson7.book.store.domain.Publisher;
import org.lesson7.book.store.repository.PublisherRepository;

public class App {

    public static void main(String[] args) {
        SessionFactory factory = HibdernateUtils.getFactory();
        PublisherRepository publisherRepository = new PublisherRepository(factory);
        Publisher publisher = publisherRepository.createPublisher("Москва 2.0");
        publisherRepository.updatePulisher(publisher.getId(), "Москва 3.0");
    }
}
