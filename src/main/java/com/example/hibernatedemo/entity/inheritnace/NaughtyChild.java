package com.example.hibernatedemo.entity.inheritnace;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Jakub krhovják on 11/2/17.
 */
@Entity
@DiscriminatorValue("NAUGHTY_CHILD")
public class NaughtyChild extends Parent {

	private String attribute;

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
}
