package com.example.hibernatedemo;

import com.example.hibernatedemo.dao.ItemDao;
import com.example.hibernatedemo.dao.ParentDao;
import com.example.hibernatedemo.dao.RecordDao;
import com.example.hibernatedemo.entity.Record;
import io.vavr.API;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
public class HibernateDemoApplicationTests {

	protected RecordDao recordDao;

	protected ParentDao parentDao;

	protected ItemDao itemDao;

//	@Bean(destroyMethod = "close")
//	public DataSource dataSource(){
//		HikariConfig hikariConfig = new HikariConfig();
//		hikariConfig.setDriverClassName("org.postgresql.Driver");
//		hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
//		hikariConfig.setUsername("postgres");
//		hikariConfig.setPassword("heslo");
//
//		hikariConfig.setMaximumPoolSize(3);
//		hikariConfig.setIdleTimeout(5000);
//		hikariConfig.setConnectionTestQuery("SELECT 1");
//		hikariConfig.setPoolName("springHikariCP");
//
//		hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
//		hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
//		hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//		hikariConfig.addDataSourceProperty("useServerPrepStmts", "true");
//
//		return new HikariDataSource(hikariConfig);
//
//
//	}

//	@Bean
//	public TransactionManager transactionManager() {
//		HibernateTransactionManager manager = new HibernateTransactionManager();
//		manager.setDataSource(dataSource());
//		manager.setSessionFactory();
//	}
//
//	@Bean
//	public SessionFactory sessionFactory() {
//		return new SessionFactoryImpl();
//	}

	public void contextLoads() {
	}

	@org.junit.Test
	public void insert() throws Exception {
		IntStream.range(0, 30).forEach(j -> {
			List<Record> records = new ArrayList<>();
			IntStream.range(0, 30).forEach(i -> {
				Record record = new Record();
				record.setName("name " + i);
				record.setDetail("detail " + i);
				records.add(record);
			});

			API.unchecked(this::sleep);
			recordDao.save(records);
		});
	}

	private boolean sleep() throws Exception {
		Thread.sleep(1000);
		return true;
	}

	@org.junit.Test
	public void simpleInsert() throws Exception {
		List<Record> records = new ArrayList<>();
		IntStream.range(0, 30).forEach(i -> {
					records.add(createRecord());

				});
		for(Record record : records) {
			recordDao.save(record);
		}

	}

	protected Record createRecord() {
		Record record = new Record();
		record.setName("name");
		record.setDetail("detail");
		return record;
	}


	@org.junit.Test
	public void select() throws Exception {
		recordDao.findAll();
	}

	@Autowired
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	@Autowired
	public void setParentDao(ParentDao parentDao) {
		this.parentDao = parentDao;
	}

	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
}
