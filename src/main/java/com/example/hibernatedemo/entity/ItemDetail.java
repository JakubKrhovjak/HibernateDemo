package com.example.hibernatedemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Created by Jakub krhovják on 10/21/17.
 */
//@Audited(targetAuditMode = NOT_AUDITED)
@Data
@Accessors(chain = true)
@Entity(name = "itemDetail")
public class ItemDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pooled")
    @SequenceGenerator(allocationSize = 1, name = "item_detail_id_seq", sequenceName = "item_detail_id_seq")
    @GenericGenerator(
            name = "pooled",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "item_detail_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "10"),
                    @Parameter(name = "optimizer", value = "pooled-lo")
            }
    )
    @Column(name = "item_detail_id")
    private Long itemDetailId;

    private String description;

    @JsonIgnoreProperties("itemDetails")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false, foreignKey = @ForeignKey(name = "item_id_fkey"))
    private Item item;

}
