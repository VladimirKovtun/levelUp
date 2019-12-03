package org.lesson7.book.store;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibdernateUtils {
    private static SessionFactory factory;

    private HibdernateUtils() {}

    static {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
