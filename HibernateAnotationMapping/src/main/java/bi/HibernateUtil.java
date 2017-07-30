package bi;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buidSessionFactory();

    private static SessionFactory buidSessionFactory() {

	try {
	    return new Configuration().configure().buildSessionFactory();

	} catch (Exception ex) {
	    // TODO: handle exception
	    System.err.println("Initial SessionFactory creatien failed" + ex);
	    throw new ExceptionInInitializerError(ex);
	}
    }

    public static SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    public static void shutDown() {
	getSessionFactory().close();
    }
}
