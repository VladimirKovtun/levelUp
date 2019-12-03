package org.lesson7.book.store.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lesson7.book.store.domain.Publisher;

@RequiredArgsConstructor
public class PublisherRepository {

    private final SessionFactory factory;

    public Publisher createPublisher(String name) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Publisher publisher = new Publisher(name);
        session.persist(publisher);

        transaction.commit();
        session.close();
        return publisher;
       }

       public Publisher updatePulisher(Integer id, String name) {
           Session session = factory.openSession();
           Transaction transaction = session.beginTransaction();

           Publisher publisher = session.get(Publisher.class, id);
           publisher.setName(name);

           transaction.commit();
           session.close();

           return publisher;
       }
}
