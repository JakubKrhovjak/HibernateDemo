package com.example.hibernatedemo;

import com.example.hibernatedemo.dao.ItemDao;
import com.example.hibernatedemo.entity.Test;
import io.vavr.API;
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

	@org.junit.Test
	public void contextLoads() {
	}

	@org.junit.Test
	public void insert() throws Exception {
		IntStream.range(0, 30).forEach(j -> {
			List<Test> tests = new ArrayList<>();
			IntStream.range(0, 30).forEach(i -> {
				Test test = new Test();
				test.setName("name " + i);
				test.setDetail("detail " + i);
				tests.add(test);
			});

			API.unchecked(this::sleep);
			itemDao.save(tests);
		});
	}

	private boolean sleep() throws Exception {
		Thread.sleep(1000);
		return true;
	}

	@org.junit.Test
	public void simpleInsert() throws Exception {
		List<Test> tests = new ArrayList<>();
		IntStream.range(0, 30).forEach(i -> {
					Test test = new Test();
					test.setName("name");
					test.setDetail("detail");
					tests.add(test);

				});
		for(Test test : tests) {
			itemDao.save(test);
		}

	}


	@org.junit.Test
	public void select() throws Exception {
		itemDao.findAll();
	}

	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
}
