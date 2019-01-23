package com.example.hibernatedemo.entity;

import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 * Created by Jakub krhovják on 10/22/17.
 */
@Entity
@Audited(targetAuditMode = NOT_AUDITED)
public class Custom {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_id_seq")
	@SequenceGenerator(allocationSize = 1, name = "custom_id_seq", sequenceName = "custom_id_seq")
	@Column(name = "custom_id", nullable = false)
	private Long customId;

	private String name;

	@ManyToMany(mappedBy = "customs", cascade = { CascadeType.PERSIST, CascadeType.MERGE})
//	@OneToMany(mappedBy = "custom",  cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private List<Item> items = new ArrayList<>();

	public Long getCustomId() {
		return customId;
	}

	public void setCustomId(Long customId) {
		this.customId = customId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		items.add(item);
	}
}
