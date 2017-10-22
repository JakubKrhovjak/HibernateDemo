package com.example.hibernatedemo.dao;

import com.example.hibernatedemo.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jakub krhovják on 10/21/17.
 */
public interface TestDao extends JpaRepository <Test, Long>{
}
