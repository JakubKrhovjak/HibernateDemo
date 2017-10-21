package com.example.hibernatedemo;

import com.example.hibernatedemo.entity.Item;
import com.example.hibernatedemo.entity.ItemDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Jakub krhovják on 10/21/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationTest {

	@Test
	public void oneToManyTest() throws Exception {
		Item item = new Item();
		item.setName("itemName");

		ItemDetail itemDetail = new ItemDetail();
		itemDetail.setDescription("detail description");
//		item.set
//
	}


}
