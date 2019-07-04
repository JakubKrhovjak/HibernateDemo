package com.example.hibernatedemo.dao;

import com.example.hibernatedemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jakub krhovják on 5/8/19.
 */
public interface BookDao extends JpaRepository<Book, Long> {
}
