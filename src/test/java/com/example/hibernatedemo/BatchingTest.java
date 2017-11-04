package com.example.hibernatedemo;

import com.example.hibernatedemo.entity.Item;
import com.example.hibernatedemo.entity.ItemDetail;
import com.example.hibernatedemo.entity.Record;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Jakub krhovják on 11/4/17.
 */
public class BatchingTest extends  HibernateDemoApplicationTests {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Before
	public void setUp() throws Exception {
		entityManager.unwrap(Session.class).setJdbcBatchSize(10);
	}

	@Test
	public void batchInsertSave() throws Exception {
		IntStream.range(0, 10).forEach(i -> recordDao.save(createRecord()));
	}

	@Test
	public void batchInsertSaveAndFlush() throws Exception {
		IntStream.range(0, 10).forEach(i -> recordDao.saveAndFlush(createRecord()));
	}



	@Test
    @Transactional
	//@Rollback(value = false)
	public void batchInsertSaveAll() throws Exception {
		entityManager.unwrap(Session.class).setJdbcBatchSize(10);
		List<Record> records = new ArrayList<>();
		IntStream.range(0, 10).forEach(i -> records.add(createRecord()));
		recordDao.save(records);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void batchUpdateSaveAll() throws Exception {
		//entityManager.unwrap(Session.class).setJdbcBatchSize(10);
		List<Record> records = new ArrayList<>();
		//recordDao.deleteAll();

	//	IntStream.range(0, 10).forEach(i -> records.add(createRecord()));
	//	recordDao.save(records);
		List<Record> savedRecords = recordDao.findAll();
		savedRecords.forEach(record -> record.setName("updated new3"));

		recordDao.save(savedRecords);
	}

	@Test
	public void oneToManyBatching() throws Exception {
		Item item = new Item();
		item.setName("itemName");

		ItemDetail itemDetail = new ItemDetail();
		itemDetail.setDescription("detail description2");
		itemDetail.setItem(item);
		//
		//		ItemDetail itemDetail2 = new ItemDetail();
		//		itemDetail2.setDescription("detail description1");
		//		itemDetail2.setItem(item);

		item.setItemDetails(getDetails(item));

		itemDao.save(item);
		//		List<ItemDetail> details = itemDao.findAll().iterator().next().getItemDetails();
	}

	@Test
	public void deleteBatching() throws Exception {
		List<Record> records = new ArrayList<>();
		//recordDao.deleteAll();

		IntStream.range(0, 10).forEach(i -> records.add(createRecord()));
		recordDao.save(records);

		recordDao.deleteInBatch(records);
	}


	@Test
	@Transactional
	@Rollback(value = false)
	public void oneToManyDeleting() throws Exception {
		Item item = new Item();
		item.setName("itemName");

		ItemDetail itemDetail = new ItemDetail();
		itemDetail.setDescription("detail description2");
		itemDetail.setItem(item);
		//
		//		ItemDetail itemDetail2 = new ItemDetail();
		//		itemDetail2.setDescription("detail description1");
		//		itemDetail2.setItem(item);

		item.setItemDetails(getDetails(item));

		itemDao.save(item);
	//	itemDao.deleteByItemId(item.getItemId());
		itemDao.delete(item);
		//		List<ItemDetail> details = itemDao.findAll().iterator().next().getItemDetails();
	}

	private List<ItemDetail> getDetails(Item item) {
		List<ItemDetail> itemDetails = new ArrayList<>();
		IntStream.range(0, 9).forEach(i -> {
				ItemDetail itemDetail = new ItemDetail();
				itemDetail.setDescription("detail description" + i);
		        itemDetail.setItem(item);
	        	itemDetails.add(itemDetail);
		});
		return itemDetails;
	}

}
