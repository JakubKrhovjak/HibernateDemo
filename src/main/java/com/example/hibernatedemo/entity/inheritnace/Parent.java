package com.example.hibernatedemo.entity.inheritnace;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.SequenceGenerator;

/**
 * Created by Jakub krhovják on 11/2/17.
 */
@Entity
@DiscriminatorColumn(name = "type")
@Inheritance
public abstract class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parent_id_seq")
	@SequenceGenerator(allocationSize = 1, name = "parent_id_seq", sequenceName = "parent_id_seq")
	private Long id;

	private String firstName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
