package com.atsistemas.concesionario.concesionarioRest.configuracion;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // Anotamos esta clase como un fichero de configuración para el contexto de Spring
@ComponentScans({
	@ComponentScan("com.atsistemas.concesionario")
})
@EnableWebMvc				// Activamos MVC para gestionar el RequestDispatcher
@EnableTransactionManagement // Anotamos la activación de la gestión de Transacciones
@EnableJpaRepositories(basePackages="com.atsistemas.concesionario.persistencia") 	// Anotamos la activación de la gestión de repositorios para el paquete 
																					// que contiene la capa de persistencia.
public class JavaConfig {

	// 1º Necesitamos un Jpa(TransactionManager)
	// 2º Necesitamos un LocalContainer(EntityManagerFactory)Bean para el Jpa(TransactionManager)
	// 3º Necesitamos un DataSource para el LocalContainer(EntityManagerFactory)Bean
	// 4º Dentro del DataSource necesitamos la configuración de la conexión del pull de BBDD
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	@Bean
	public DataSource dataSource (){
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("jdbc:derby://localhost:1527/concesionario;create=true");
		basicDataSource.setUsername("admin");
		basicDataSource.setPassword("admin");
		basicDataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver40");
		
		return basicDataSource;
	}
		
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		entityManagerFactoryBean.setDataSource(dataSource);		
		entityManagerFactoryBean.setPackagesToScan("com.atsistemas.concesionario.entidades");		
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.default_schema", "concesionario");
		
		entityManagerFactoryBean.setJpaProperties(properties);
		
		return(entityManagerFactoryBean);
	}
}
