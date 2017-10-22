package com.example.hibernatedemo.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub krhovják on 10/21/17.
 */

@Entity
//@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pooled")
//	@SequenceGenerator(allocationSize = 1, name = "item_id_seq", sequenceName = "item_id_seq")
	@GenericGenerator(
			name = "pooled",
			strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
			parameters = {
					@Parameter(name = "sequence_name", value = "item_id_seq"),
					@Parameter(name = "initial_value", value = "1"),
					@Parameter(name = "increment_size", value = "3"),
					@Parameter(name = "optimizer", value = "pooled-lo")
			}
	)
	private Long itemId;

	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.ALL)
	private List<ItemDetail> itemDetails;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "item_custom",
			uniqueConstraints = {@UniqueConstraint(name = "item_custom_pkey", columnNames = {"item_id", "custom_id"})},
			joinColumns = @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name ="item_custom_custom_fkey" )),
			inverseJoinColumns = @JoinColumn(name = "custom_id",foreignKey = @ForeignKey(name = "item_custom_item_id_fkey"))
	)
	private List<Custom> customs = new ArrayList<>();

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

	public List<Custom> getCustoms() {
		return customs;
	}

	public void setCustoms(List<Custom> customs) {
		this.customs = customs;
	}

	public void addCustom(Custom custom) {
		customs.add(custom);
	}
}
