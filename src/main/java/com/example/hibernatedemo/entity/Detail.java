package com.example.hibernatedemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Created by Jakub krhovják on 5/8/19.
 */
@Entity
@Accessors(chain = true)
//@EqualsAndHashCode(of = {"id"})
@Data
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_id_seq")
//    @SequenceGenerator(allocationSize = 1, name = "detail_id_seq", sequenceName = "detail_id_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account", referencedColumnName = "account", columnDefinition = "varchar(255)")
    private Book book;
}
