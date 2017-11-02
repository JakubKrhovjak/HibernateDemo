package com.example.hibernatedemo.dao;

import com.example.hibernatedemo.entity.inheritnace.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jakub krhovják on 11/2/17.
 */
public interface ParentDao extends JpaRepository<Parent, Long> {
}
