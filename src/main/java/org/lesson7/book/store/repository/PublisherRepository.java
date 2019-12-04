package org.lesson7.book.store.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.lesson7.book.store.domain.Publisher;
import java.util.List;

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

       public Publisher updatePublisher(Integer id, String name) {
           Session session = factory.openSession();
           Transaction transaction = session.beginTransaction();

           Publisher publisher = session.get(Publisher.class, id);
           publisher.setName(name);

           transaction.commit();
           session.close();

           return publisher;
       }

    public Publisher deletePublisher(Integer id) {
        Session session = factory.openSession();
        session.beginTransaction();

        Publisher publisher = session.get(Publisher.class, id);
        session.delete(publisher);

        session.getTransaction().commit();
        session.close();

        return publisher;
    }

    public Publisher getPublisherById(Integer id) {
        Session session = factory.openSession();

        Publisher publisher = session.get(Publisher.class, id);

        session.close();

        return publisher;
    }

    public List<Publisher> getAllPublisher() {
        List<Publisher> publishersList;
        Session session = factory.openSession();

        publishersList = session.createQuery("From Publisher", Publisher.class).getResultList();

        session.close();

        return publishersList;
    }
}
