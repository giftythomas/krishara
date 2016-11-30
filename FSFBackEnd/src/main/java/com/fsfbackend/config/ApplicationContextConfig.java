package com.fsfbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fsfbackend.dao.UserDAO;
import com.fsfbackend.dao.UserDAOImpl;
import com.fsfbackend.model.Category;
import com.fsfbackend.model.User;



@Configuration
@ComponentScan("com.fsfbackend")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name="dataSource")
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/fsf");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory sessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder session= new LocalSessionFactoryBuilder(dataSource);
		session.addProperties(getHibernateProperties());
		session.addAnnotatedClass(User.class);
		session.addAnnotatedClass(Category.class);
		return session.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	@Autowired
	@Bean(name="userDAO")
	public UserDAO userDAOImpl(SessionFactory sessionFactory){
		return new UserDAOImpl(sessionFactory);
	}
		
}
