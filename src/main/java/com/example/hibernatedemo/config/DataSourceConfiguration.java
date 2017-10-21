package com.example.hibernatedemo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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

}
