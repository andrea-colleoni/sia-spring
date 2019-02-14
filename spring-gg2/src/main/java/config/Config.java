package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import business.PersonaManager;

@Configuration
public class Config {
	
	@Bean
	@Scope("singleton") // default
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("gg2-spring");
	}
	
	@Bean
	@Scope("singleton") // default
	public EntityManagerFactory entityManagerFactory2() {
		return Persistence.createEntityManagerFactory("gg2-spring2");
	}
	
	@Bean(name="db1")
	@Scope("prototype")
	public EntityManager entityManager() {
		return entityManagerFactory().createEntityManager();
	}
	
	@Bean(name="db2")
	@Scope("prototype")
	public EntityManager entityManager2() {
		return entityManagerFactory2().createEntityManager();
	}
	
	@Bean
	@Scope("singleton") // default
	public PersonaManager personaManager() {
		return new PersonaManager();
	}

}
