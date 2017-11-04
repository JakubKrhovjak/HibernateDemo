package com.example.hibernatedemo.dao;

import com.example.hibernatedemo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jakub krhovják on 10/22/17.
 */
public interface ItemDao extends JpaRepository<Item, Long> {

//	@Query("delete from itemDetail i where i.item in :items")
//	public void myDelete(@Param("items") List<Item> items);
   //@Modifying


	void deleteByItemId(Long itemId);
}
