package com.example.hibernatedemo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Jakub krhovják on 10/21/17.
 */
@Configuration
public class DataSourceConfiguration {

	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("org.postgresql.Driver");
		hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
		hikariConfig.setUsername("postgres");
		hikariConfig.setPassword("heslo");

		hikariConfig.setMaximumPoolSize(3);
		hikariConfig.setIdleTimeout(5000);
		hikariConfig.setConnectionTestQuery("SELECT 1");
		hikariConfig.setPoolName("springHikariCP");

		hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
		hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
		hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		hikariConfig.addDataSourceProperty("useServerPrepStmts", "true");

       return new HikariDataSource(hikariConfig);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.example.hibernatedemo" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	public Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.jdbc.batch_size", "10");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		properties.setProperty("hibernate.generate_statistics", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}

}
