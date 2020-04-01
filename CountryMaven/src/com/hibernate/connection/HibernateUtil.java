package com.hibernate.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private StandardServiceRegistry registry;
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create registry
				registry = new StandardServiceRegistryBuilder().configure().build();
				// Create MetadataSources
				MetadataSources sources = new MetadataSources(registry);
				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();
				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	public StandardServiceRegistry getRegistry() {
		return registry;
	}

	public void setRegistry(StandardServiceRegistry registry) {
		this.registry = registry;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
