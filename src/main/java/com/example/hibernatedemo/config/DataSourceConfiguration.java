package com.example.hibernatedemo.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Jakub krhovják on 10/21/17.
 */
@Configuration
public class DataSourceConfiguration {


//    @Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setDriverClassName("org.postgresql.Driver");
//        hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
//        hikariConfig.setUsername("postgres");
//        hikariConfig.setPassword("postgres");
//
//        hikariConfig.setMaximumPoolSize(3);
//        hikariConfig.setIdleTimeout(5000);
//        hikariConfig.setConnectionTestQuery("SELECT 1");
//        hikariConfig.setPoolName("springHikariCP");
//
//        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
//        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
//        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//        hikariConfig.addDataSourceProperty("useServerPrepStmts", "true");
//
//        return new HikariDataSource(hikariConfig);
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan(new String[]{"com.example.hibernatedemo"});
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(additionalProperties());
//
//        return em;
//    }
//
//    public Properties additionalProperties() {
//        Properties properties = new Properties();
//
////      Default values
////		properties.setProperty("hibernate.query.plan_cache_max_size","2048");
////		properties.setProperty("hibernate.query.plan_parameter_metadata_max_si","128");
//
//        properties.setProperty("hibernate.order_updates", "true");
//        properties.setProperty("hibernate.order_inserts", "true");
//        properties.setProperty("hibernate.jdbc.batch_size", "10");
//        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.generate_statistics", "true");
//        properties.setProperty("hibernate.format_sql", "true");
//        properties.setProperty("hibernate.naming.physical-strategy", "com.example.hibernatedemo.strategy.PhysicalNamingStrategyImpl");
//
//
//        return properties;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//
//        return transactionManager;
//    }


}
