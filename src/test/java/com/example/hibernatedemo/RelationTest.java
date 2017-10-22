package com.example.hibernatedemo;

import com.example.hibernatedemo.dao.ItemDao;
import com.example.hibernatedemo.entity.Item;
import com.example.hibernatedemo.entity.ItemDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by Jakub krhovják on 10/21/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationTest {

	private ItemDao itemDao;

	@Test
	public void oneToManyTest() throws Exception {
		Item item = new Item();
		item.setName("itemName");

		ItemDetail itemDetail = new ItemDetail();
		itemDetail.setDescription("detail description2");
		itemDetail.setItem(item);

		ItemDetail itemDetail2 = new ItemDetail();
		itemDetail2.setDescription("detail description1");
		itemDetail2.setItem(item);

		item.setItemDetails(Arrays.asList(itemDetail, itemDetail2));

		itemDao.saveAndFlush(item);
//		List<ItemDetail> details = itemDao.findAll().iterator().next().getItemDetails();
	}

	@Test
	public void delete() throws Exception {
		itemDao.delete(itemDao.findAll().iterator().next());
	}

	@Test
	public void select() throws Exception {
		itemDao.findAll();
	}

	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
}