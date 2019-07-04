package com.example.hibernatedemo.dto;

import com.example.hibernatedemo.entity.ItemDetail;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by Jakub krhovják on 5/12/19.
 */

@Data
@Accessors(chain = true)
public class ItemDto {

    private Long id;
    private String name;
    private List<ItemDetail> details;

}
