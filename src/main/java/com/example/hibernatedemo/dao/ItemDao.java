package com.example.hibernatedemo.dao;

import com.example.hibernatedemo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jakub krhovják on 10/21/17.
 */
public interface ItemDao extends JpaRepository <Item, Long>{
}
