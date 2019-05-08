package com.example.hibernatedemo.dao;

import com.example.hibernatedemo.entity.Item;
import com.example.hibernatedemo.entity.ItemDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by Jakub krhovják on 11/5/17.
 */
public interface ItemDetailDao extends JpaRepository<ItemDetail, Long> {

    List<ItemDetail> findByItem(Item item);
}
