package com.example.hibernatedemo;

import com.example.hibernatedemo.entity.Record;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Jakub krhovják on 11/4/17.
 */
public class BatchingTest extends  HibernateDemoApplicationTests {

	@Test
	public void batchInsertSave() throws Exception {
		IntStream.range(0, 10).forEach(i -> recordDao.save(createRecord()));
	}

	@Test
	public void batchInsertSaveAndFlush() throws Exception {
		IntStream.range(0, 10).forEach(i -> recordDao.saveAndFlush(createRecord()));
	}

	@Test
	public void batchInsertSaveAll() throws Exception {
		List<Record> records = new ArrayList<>();
		IntStream.range(0, 10).forEach(i -> records.add(createRecord()));
		recordDao.save(records);
	}
}
