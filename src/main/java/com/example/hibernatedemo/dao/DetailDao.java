package com.example.hibernatedemo.dao;

import com.example.hibernatedemo.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jakub krhovják on 5/8/19.
 */
public interface DetailDao  extends JpaRepository<Detail, Long> {


}
