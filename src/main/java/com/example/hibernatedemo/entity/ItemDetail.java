package com.example.hibernatedemo.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * Created by Jakub krhovják on 10/21/17.
 */

@Entity
public class ItemDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_detail_id_seq")
	@SequenceGenerator(allocationSize = 1, name = "item_detail_id_seq", sequenceName = "item_detail_id_seq")
//	@GenericGenerator(
//			name = "pooled-item_detail",
//			strategy = "org.hibernate.itemDetailId.enhanced.SequenceStyleGenerator",
//			parameters = {
//					@Parameter(name = "sequence_name", value = "item_detail_id_seq"),
//					@Parameter(name = "initial_value", value = "1"),
//					@Parameter(name = "increment_size", value = "3"),
//					@Parameter(name = "optimizer", value = "pooled-lo")
//			}
//	)

	private Long itemDetailId;

	private String description;

	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false, foreignKey = @ForeignKey(name = "item_id_fkey"))
	private Item item;

	public Long getItemDetailId() {
		return itemDetailId;
	}

	public void setItemDetailId(Long itemDetailId) {
		this.itemDetailId = itemDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
