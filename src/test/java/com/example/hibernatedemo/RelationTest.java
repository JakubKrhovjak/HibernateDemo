package com.example.hibernatedemo;

import com.example.hibernatedemo.dao.ItemDao;
import com.example.hibernatedemo.entity.Custom;
import com.example.hibernatedemo.entity.Item;
import com.example.hibernatedemo.entity.ItemDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Jakub krhovják on 10/21/17.
 */

public class RelationTest extends HibernateDemoApplicationTests {

	private ItemDao itemDao;

	@Test
	public void oneToManyTest() throws Exception {
		Item item = new Item();
		item.setName("itemName");

		ItemDetail itemDetail = new ItemDetail();
		itemDetail.setDescription("detail description2");
		itemDetail.setItem(item);
//
//		ItemDetail itemDetail2 = new ItemDetail();
//		itemDetail2.setDescription("detail description1");
//		itemDetail2.setItem(item);

		item.setItemDetails(Arrays.asList(itemDetail));

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

	@Test
	public void manyToMany() throws Exception {
		itemDao.save(createItem());
	}

	@Test
	public void testTest() throws Exception {
		List<Item> items = new ArrayList<>();
		IntStream.range(0, 20).forEach(i -> items.add(createItem()));
       //items.forEach(item -> itemDao.save(item));
		itemDao.save(items);
	}

	@Test
	@Transactional
	public void lazyLoadTest() throws Exception {
		//oneToManyTest();
		Item item = itemDao.findAll().iterator().next();
		item.getItemDetails().iterator().next();

	}

	private Item createItem() {
		Item item = new Item();
		item.setName("itemName");

		Custom custom = new Custom();
		custom.setName("custom name");
		item.addCustom(custom);

		return item;
	}

	@Test
	public void deleteManyTo() throws Exception {
		itemDao.delete(itemDao.findAll().iterator().next());
	}

	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
}
