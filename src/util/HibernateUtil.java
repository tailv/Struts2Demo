package util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	static Configuration config = new AnnotationConfiguration()
			.configure("hibernate.cfg.xml");
	static SessionFactory sessionFactory = config.buildSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}