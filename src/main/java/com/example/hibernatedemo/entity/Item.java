package com.example.hibernatedemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

/**
 * Created by Jakub krhovják on 10/21/17.
 */

@Entity
//@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
	@SequenceGenerator(allocationSize = 1, name = "item_id_seq", sequenceName = "item_id_seq")
//	@GenericGenerator(
//			name = "pooled",
//			strategy = "org.hibernate.itemId.enhanced.SequenceStyleGenerator",
//			parameters = {
//					@Parameter(name = "sequence_name", value = "item_id_seq"),
//					@Parameter(name = "initial_value", value = "1"),
//					@Parameter(name = "increment_size", value = "3"),
//					@Parameter(name = "optimizer", value = "pooled-lo")
//			}
//	)

	private Long itemId;

	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.ALL)
	private List<ItemDetail> itemDetails;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItemDetail> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(List<ItemDetail> itemDetails) {
		this.itemDetails = itemDetails;
	}
}
