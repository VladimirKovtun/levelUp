package org.book.store;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtils {
    private static SessionFactory factory;

    private HibernateUtils() {}

    static {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
