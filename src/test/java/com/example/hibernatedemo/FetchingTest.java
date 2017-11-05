package com.example.hibernatedemo;

import com.example.hibernatedemo.dto.RecordDto;
import com.example.hibernatedemo.entity.Item;
import com.example.hibernatedemo.entity.ItemDetail;
import org.junit.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Jakub krhovják on 11/4/17.
 */
public class FetchingTest extends HibernateDemoApplicationTests {
	@Test
	public void simpleDto() throws Exception {
		Pageable topTen = new PageRequest(0, 10);
		List<RecordDto> recordDtos = recordDao.getRecordDtos(topTen);
	}


	@Test
	public void nativeDto() throws Exception {
		Pageable topTen = new PageRequest(0, 10);
		recordDao.getNativeRecordDtos();
//		List<RecordDto> recordDtos = recordDao.getNativeRecordDtos();
	}

	@Test
	public void lazyFetch() throws Exception {
		Item item = new Item();
		item.setItemId(19L);
		List<ItemDetail> itemDetails = itemDetailDao.findByItem(item);
		//itemDetails.iterator().next().getItem().getName();
	}
}
