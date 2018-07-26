package org.o2.registersvc.intg.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtility {

	// 0-param constructor
	private HibernateUtility() {

	}

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static synchronized SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				Configuration configuration = new Configuration()
						.configure(HibernateUtility.class.getResource("/hibernate.cfg.xml"));
				StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
				serviceRegistryBuilder.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}
		} catch (Exception e) {
			System.out.println("Initial SessionFactory cration failed: " + e);
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}
