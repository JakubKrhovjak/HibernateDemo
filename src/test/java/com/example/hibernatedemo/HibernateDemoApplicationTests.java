package com.example.hibernatedemo;

import com.example.hibernatedemo.dao.ItemDao;
import com.example.hibernatedemo.entity.Item;
import io.vavr.API;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateDemoApplicationTests {

	private ItemDao itemDao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void insert() throws Exception {
		IntStream.range(0, 30).forEach(j -> {
			List<Item> items = new ArrayList<>();
			IntStream.range(0, 30).forEach(i -> {
				Item item = new Item();
				item.setName("name " + i);
				item.setDetail("detail " + i);
				items.add(item);
			});

			API.unchecked(this::sleep);
			itemDao.save(items);
		});
	}

	private boolean sleep() throws Exception {
		Thread.sleep(1000);
		return true;
	}

	@Test
	public void simpleInsert() throws Exception {
		List<Item> items = new ArrayList<>();
		IntStream.range(0, 30).forEach(i -> {
					Item item = new Item();
					item.setName("name");
					item.setDetail("detail");
					items.add(item);

				});
		for(Item item : items) {
			itemDao.save(item);
		}

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
