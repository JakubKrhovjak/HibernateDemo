package com.example.hibernatedemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub krhovják on 5/8/19.
 */

@Entity
@Accessors(chain = true)
//@EqualsAndHashCode(of = {"id"})
@Data
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
//    @SequenceGenerator(allocationSize = 1, name = "book_id_seq", sequenceName = "book_id_seq")
    private Long id;
//
//    @NaturalId
    @Column(name = "account")
    private String account;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
     private List<Detail> details = new ArrayList<>();

}
