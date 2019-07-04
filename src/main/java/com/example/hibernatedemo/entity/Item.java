package com.example.hibernatedemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub krhovják on 10/21/17.
 */

@Entity
//@Audited
//@Table(name = "item")
@Accessors(chain = true)
@Data
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
    @Column(name = "item_id")
    private Long itemId;

    private String name;

    @JsonIgnoreProperties("item")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ItemDetail> itemDetails;

    @JsonIgnoreProperties
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "item_custom",
            uniqueConstraints = {@UniqueConstraint(name = "item_custom_pkey", columnNames = {"item_id", "custom_id"})},
            joinColumns = @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "item_custom_custom_fkey")),
            inverseJoinColumns = @JoinColumn(name = "custom_id", foreignKey = @ForeignKey(name = "item_custom_item_id_fkey"))
    )
    private List<Custom> customs = new ArrayList<>();

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
