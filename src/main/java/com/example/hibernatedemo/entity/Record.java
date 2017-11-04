package com.example.hibernatedemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Created by Jakub krhovják on 10/21/17.
 */

@Entity
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "record_id_seq")
	@SequenceGenerator(allocationSize = 1, name = "record_id_seq", sequenceName = "record_id_seq")
//	@GenericGenerator(
//			name = "pooled",
//			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//			parameters = {
//					@Parameter(name = "sequence_name", value = "record_id_seq"),
//					@Parameter(name = "initial_value", value = "1"),
//					@Parameter(name = "increment_size", value = "3"),
//					@Parameter(name = "optimizer", value = "pooled-lo")
//			}
//	)
	public long id;

	private String name;

	private String detail;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
