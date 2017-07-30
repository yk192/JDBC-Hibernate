package bi;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
	try {
	    return new Configuration().configure().buildSessionFactory();

	}

	catch (Exception ex) {
	    throw new ExceptionInInitializerError(ex);
	}

    }

    public static SessionFactory getSessionfactory() {
	return sessionFactory;
    }

    public static void shutDown() {
	getSessionfactory().close();
    }

}
