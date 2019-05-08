package com.example.hibernatedemo.dto;

/**
 * Created by Jakub krhovják on 11/4/17.
 */
public class RecordDto {

    public long id;

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RecordDto(long id, String name) {
        this.id = id;
        this.name = name;
    }
}