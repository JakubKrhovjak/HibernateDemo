package com.example.hibernatedemo.dao;

import com.example.hibernatedemo.dto.RecordDto;
import com.example.hibernatedemo.entity.Record;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * Created by Jakub krhovják on 10/21/17.
 */

public interface RecordDao extends JpaRepository <Record, Long>{

	@QueryHints(value = { @QueryHint(name = org.hibernate.annotations.QueryHints.FLUSH_MODE, value = "ALWAYS") })
	public default void mySave(Record record) {
		save(record);
	}

	@Query("select new com.example.hibernatedemo.dto.RecordDto(r.id, r.name) from Record r order by r.name desc")
	List<RecordDto> getRecordDtos(Pageable pageable);


	@Query(value = "select r.id, r.name from record r order by r.name desc", nativeQuery = true)
	List<Object[]> getNativeRecordDtos();

}
