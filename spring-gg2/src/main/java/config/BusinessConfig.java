package config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan(basePackages = { "business" })
public class BusinessConfig {
	

//	public EntityManagerFactory entityManagerFactory() {
//		return Persistence.createEntityManagerFactory("gg2-spring");
//	}
	
//	@Bean
//	@Scope("singleton") // default
//	public EntityManagerFactory entityManagerFactory2() {
//		return Persistence.createEntityManagerFactory("gg2-spring2");
//	}
	
	@Bean(name="db1")
	@Scope("prototype")
	public EntityManager entityManager() {
		return entityManagerFactory().getObject().createEntityManager();
	}
	
//	@Bean(name="db2")
//	@Scope("prototype")
//	public EntityManager entityManager2() {
//		return entityManagerFactory2().createEntityManager();
//	}
	
	@Bean
	@Scope("singleton") // default
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(new String[] { "model" });
		
		JpaVendorAdapter jva = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(jva);
		
		emf.setJpaProperties(additionalProperties());
		return emf;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
		ds.setUrl("jdbc:derby:C:\\Users\\andre\\git\\sia-spring\\spring-gg2\\corsospring;create=true");
//		ds.setUsername(username);
//		ds.setPassword(password);
		return ds;
	}
	
	Properties additionalProperties() {
		Properties props = new Properties();
		props.setProperty("javax.persistence.schema-generation.database.action", "create");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
		return props;
	}

}
