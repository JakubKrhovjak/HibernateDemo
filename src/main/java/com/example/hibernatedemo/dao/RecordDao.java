package com.example.hibernatedemo.dao;

import com.example.hibernatedemo.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;

/**
 * Created by Jakub krhovják on 10/21/17.
 */
public interface RecordDao extends JpaRepository <Record, Long>{

	@QueryHints(value = { @QueryHint(name = org.hibernate.annotations.QueryHints.FLUSH_MODE, value = "ALWAYS") })
	public default void mySave(Record record) {
		save(record);
	}
}
