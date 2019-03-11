package it.eng.hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {

	static SessionFactory factory;

	static {
		// Used for creating SessionFactory
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		factory = meta.getSessionFactoryBuilder().build();

	}

	public static SessionFactory SessionFactory() {
		return factory;
	}

	public static void destroySessionFactory() {
		factory.close();
	}
}
