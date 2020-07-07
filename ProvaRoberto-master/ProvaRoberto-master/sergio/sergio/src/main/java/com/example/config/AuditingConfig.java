package com.example.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.DAO.AuditingDAO;

@Configuration
@ComponentScan("com.example.sergio.Entities")
public class AuditingConfig {

	@Bean
	public AuditingDAO auditingDAO() { //default beanId: studentDAO (nome do método)
		return new AuditingDAO();
	}

	@Bean
	public EntityManager entityManager() {
		EntityManagerFactory emFactory = null;

		try {
			// Create the Factory
			emFactory = Persistence.createEntityManagerFactory("auditing_PU");
		} catch (Throwable e) {
			// Make sure you log the exception , as it might be swallowed
			System.err.println("Error creating EntityManagerFactory ." + e);
			throw new ExceptionInInitializerError(e);
		}
		return emFactory.createEntityManager();
	}
}
