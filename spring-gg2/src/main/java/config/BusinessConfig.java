package config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan(basePackages = { "business" })
public class BusinessConfig {

	@Bean(name="db1")
	@Scope("prototype")
	@Profile("test")
	public EntityManager entityManagerTest() {
		return entityManagerFactoryTest().getObject().createEntityManager();
	}
	
	@Bean(name="db1")
	@Scope("prototype")
	@Profile("produzione")
	public EntityManager entityManagerProduzione() {
		return entityManagerFactoryProd().getObject().createEntityManager();
	}
	
	@Bean
	@Scope("singleton") // default
	@Profile("test")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryTest() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSourceDerby());
		emf.setPackagesToScan(new String[] { "model" });
		
		JpaVendorAdapter jva = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(jva);
		
		emf.setJpaProperties(additionalPropertiesDerby());
		return emf;
	}
	
	@Bean
	@Scope("singleton") // default
	@Profile("produzione")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryProd() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSourceMySql());
		emf.setPackagesToScan(new String[] { "model" });
		
		JpaVendorAdapter jva = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(jva);
		
		emf.setJpaProperties(additionalPropertiesMySql());
		return emf;
	}
	
	
	@Bean
	@Profile("test")
	public DataSource dataSourceDerby() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.apache.derby.jdbc.EmbeddedDriver");
		ds.setUrl("jdbc:derby:C:\\Users\\andre\\git\\sia-spring\\spring-gg2\\corsospring;create=true");
		return ds;
	}
	
	@Bean
	@Profile("produzione")
	public DataSource dataSourceMySql() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUrl("jdbc:mariadb://localhost:3306/corsojpa");
		ds.setUsername("root");		
		return ds;
	}
	
	Properties additionalPropertiesDerby() {
		Properties props = new Properties();
		props.setProperty("javax.persistence.schema-generation.database.action", "create");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
		return props;
	}
	
	Properties additionalPropertiesMySql() {
		Properties props = new Properties();
		props.setProperty("javax.persistence.schema-generation.database.action", "create");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return props;
	}

}
